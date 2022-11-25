plugins {
    application
}

dependencies {
    implementation(project(":mod1"))

    implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest:7.18.0")
}

application {
    mainClass.set("Main")
}
