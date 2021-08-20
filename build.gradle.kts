plugins {
    kotlin("jvm") version "1.5.10"
    `maven-publish`
    `java-library`
}

group = "com.alexrebello"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://pkgs.dev.azure.com/lexrebello/poc-azure-artifact/_packaging/poc/maven/v1")
        credentials {
            username = "poc"
            password = System.getenv("AZURE_ARTIFACTS_ENV_ACCESS_TOKEN") ?: ""
        }
    }
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
            url = uri("https://pkgs.dev.azure.com/lexrebello/poc-azure-artifact/_packaging/poc/maven/v1")
            credentials {
                username = "poc"
                password = System.getenv("AZURE_ARTIFACTS_ENV_ACCESS_TOKEN") ?: ""
            }
        }
    }
}