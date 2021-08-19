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
            url =
                uri(if (System.getenv("ARTIFACTS_ENV_ACCESS_URI") != null) System.getenv("ARTIFACTS_ENV_ACCESS_URI") else " ")
            name = "poc"
            credentials {
                username =
                    if (System.getenv("ARTIFACTS_ENV_ACCESS_USERNAME") != null) System.getenv("ARTIFACTS_ENV_ACCESS_USERNAME") else " "
                password =
                    if (System.getenv("ARTIFACTS_ENV_ACCESS_TOKEN") != null) System.getenv("ARTIFACTS_ENV_ACCESS_TOKEN") else " "
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
}

repositories {
    maven {
        url =
            uri(if (System.getenv("ARTIFACTS_ENV_ACCESS_URI") != null) System.getenv("ARTIFACTS_ENV_ACCESS_URI") else " ")
        name = "poc"
        credentials {
            username =
                if (System.getenv("ARTIFACTS_ENV_ACCESS_USERNAME") != null) System.getenv("ARTIFACTS_ENV_ACCESS_USERNAME") else " "
            password =
                if (System.getenv("ARTIFACTS_ENV_ACCESS_TOKEN") != null) System.getenv("ARTIFACTS_ENV_ACCESS_TOKEN") else " "
        }
        authentication {
            create<BasicAuthentication>("basic")
        }
    }
}
