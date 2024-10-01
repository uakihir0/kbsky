import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("maven-publish")
    id("signing")

    id("com.vanniktech.maven.publish")
    id("org.jetbrains.dokka")
}

publishing {
    repositories {
        maven {
            url = uri("https://repo.repsy.io/mvn/uakihir0/public")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("PASSWORD")
            }
        }
    }

    // Configure all publications
    publications.withType<MavenPublication> {

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

mavenPublishing {
    configure(
        KotlinMultiplatform(
            javadocJar = JavadocJar.Dokka("dokkaHtml")
        )
    )
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    if (project.hasProperty("mavenCentralUsername") ||
        System.getenv("ORG_GRADLE_PROJECT_mavenCentralUsername") != null) {
        signAllPublications()
    }
}

signing {
    if (project.hasProperty("mavenCentralUsername") ||
        System.getenv("ORG_GRADLE_PROJECT_mavenCentralUsername") != null) {
        useGpgCmd()
    }
}

