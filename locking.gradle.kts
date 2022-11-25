val locksDisabled = providers.gradleProperty("disableLocks").orNull == "true"

if (!locksDisabled) {
    allprojects {
        configurations.configureEach {
            resolutionStrategy.activateDependencyLocking()
        }

        dependencyLocking {
            lockMode.set(LockMode.STRICT)
        }

        tasks.register("lockDeps") {
            doFirst {
                require(gradle.startParameter.isWriteDependencyLocks) {
                    "The task '$name' must be run with '--write-locks' parameter"
                }
            }
            doLast {
                configurations.filter {
                    it.isCanBeResolved
                }.forEach { it.resolve() }
            }
        }
    }
}
