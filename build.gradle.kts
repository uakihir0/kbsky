plugins {
    id("root.publications")

    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.kotlin.serialization).apply(false)
    alias(libs.plugins.kotlin.cocoapods).apply(false)

    alias(libs.plugins.dokka).apply(false)
    alias(libs.plugins.maven.publish).apply(false)

    alias(libs.plugins.git.versioning)
}

allprojects {
    group = "work.socialhub.kbsky"
    version = "0.3.0-EBX-SNAPSHOT"

    repositories {
        mavenCentral()
        // Repsy.io repository for snapshot packages.
        // maven { url = uri("https://repo.repsy.io/mvn/uakihir0/public") }
    }
}

gitVersioning.apply {
    refs {
        considerTagsOnBranches = true
        tag("v(?<version>.*)") {
            version = "\${ref.version}"
        }
    }
}

tasks.wrapper {
    gradleVersion = "8.10.2"
    distributionType = Wrapper.DistributionType.ALL
}

