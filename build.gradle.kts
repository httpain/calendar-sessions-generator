plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("kapt") version "1.9.21"
    id("application")
}

group = "com.httpain"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("info.picocli:picocli:4.7.5")
    kapt("info.picocli:picocli-codegen:4.7.5")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

kapt {
    arguments {
        arg("project", "${project.group}/${project.name}")
    }
}

application {
    mainClass = "com.httpain.sessions.CalendarGeneratorCommandKt"
}

