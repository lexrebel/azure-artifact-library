plugins {
    kotlin("jvm") version "1.5.10"
    `maven-publish`
}

group = "com.alexrebello"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.alexrebello"
            artifactId = "poc-azure-artifacts"
            version = "1.0-SNAPSHOT"

            from(components["java"])
        }
    }
}