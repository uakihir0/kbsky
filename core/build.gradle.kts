plugins {
    kotlin("multiplatform") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"
    id("maven-publish")
}

kotlin {
    jvmToolchain(17)

    jvm { withJava() }
    iosX64 {
        binaries.framework { baseName = "KBsky" }
    }
    iosArm64 {
        binaries.framework { baseName = "KBsky" }
    }
    iosSimulatorArm64 {
        binaries.framework { baseName = "KBsky" }
    }
    macosX64 {
        binaries.framework { baseName = "KBsky" }
    }
    macosArm64 {
        binaries.framework { baseName = "KBsky" }
    }

    sourceSets {
        val kotestVersion = "5.8.0"

        commonMain.dependencies {
            implementation("io.ktor:ktor-client-core:2.3.7")
            implementation("work.socialhub:khttpclient:0.0.1-SNAPSHOT")
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
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
