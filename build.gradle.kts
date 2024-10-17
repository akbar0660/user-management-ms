plugins {
    id("io.spring.dependency-management") version "1.1.0"
}

subprojects {
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
