plugins {
    id("root.publications")

    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.kotlin.serialization).apply(false)
    alias(libs.plugins.kotlin.cocoapods).apply(false)

    alias(libs.plugins.dokka).apply(false)
    alias(libs.plugins.maven.publish).apply(false)

}

allprojects {
    group = "work.socialhub.kbsky"
    version = "0.0.1"

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.repsy.io/mvn/uakihir0/public") }
    }
}

tasks.wrapper {
    gradleVersion = "8.10.2"
    distributionType = Wrapper.DistributionType.ALL
}

tasks.create("version") {
    doLast { println(project.version) }
}
