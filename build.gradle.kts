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

java {
    withSourcesJar()
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
    repositories {
        maven {
            url = uri(System.getenv("AZURE_ARTIFACTS_ENV_ACCESS_URI"))
            name = "poc"
            credentials {
                username = System.getenv("AZURE_ARTIFACTS_ENV_ACCESS_USERNAME")
                password = System.getenv("AZURE_ARTIFACTS_ENV_ACCESS_TOKEN")
            }
        }
    }
}

repositories {
    maven {
        url = uri(System.getenv("AZURE_ARTIFACTS_ENV_ACCESS_URI"))
        name = "poc"
        credentials {
            username = System.getenv("AZURE_ARTIFACTS_ENV_ACCESS_USERNAME")
            password = System.getenv("AZURE_ARTIFACTS_ENV_ACCESS_TOKEN")
        }
    }
}
