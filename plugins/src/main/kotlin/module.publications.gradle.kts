plugins {
    id("maven-publish")
    id("signing")
}

publishing {

    // Configure all publications
    publications.withType<MavenPublication> {

        // Stub javadoc.jar artifact
        artifact(
            tasks.register("${name}JavadocJar", Jar::class) {
                archiveAppendix.set(this@withType.name)
                archiveClassifier.set("javadoc")
            }
        )

        // Provide artifacts information required by Maven Central
        pom {
            name.set("kbsky")
            description.set("Kotlin multiplatform Bluesky/ATProtocol core library.")
            url.set("https://github.com/uakihir0/kbsky")

            licenses {
                license {
                    name.set("MIT License")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }

            developers {
                developer {
                    id.set("uakihir0")
                    name.set("URUSHIHARA Akihiro")
                    email.set("a.urusihara@gmail.com")
                }
            }

            scm {
                url.set("https://github.com/uakihir0/kbsky")
            }
        }
    }
}

signing {
    if (project.hasProperty("signing.gnupg.keyName")) {
        useGpgCmd()
        sign(publishing.publications)
    }
}