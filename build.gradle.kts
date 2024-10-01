plugins {
    id("root.publications")
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
