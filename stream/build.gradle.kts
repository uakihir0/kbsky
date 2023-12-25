plugins {
    kotlin("multiplatform") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("maven-publish")
}

kotlin {
    jvmToolchain(17)

    jvm { withJava() }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosX64()
    macosArm64()

    sourceSets {
        val kotlinxVersion = "1.6.2"
        val kotestVersion = "5.8.0"

        commonMain.dependencies {
            implementation(project(":core"))
            implementation("work.socialhub:khttpclient:0.0.1-SNAPSHOT")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxVersion")
        }

        // for test (kotlin/jvm)
        jvmTest.dependencies {
            implementation(kotlin("test"))
            implementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
            implementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
        }
    }
}


tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
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
}
