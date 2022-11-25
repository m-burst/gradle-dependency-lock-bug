plugins {
    java
}

apply(from = "locking.gradle.kts")

allprojects {
    apply(plugin = "java")

    repositories {
        mavenCentral()
    }
}
