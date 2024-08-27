import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform") version libs.versions.kotlin
    kotlin("native.cocoapods") version libs.versions.kotlin
    kotlin("plugin.serialization") version libs.versions.kotlinSerialization
}

kotlin {

    val xcf = XCFramework("kbsky")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
        macosX64(),
        macosArm64(),
    ).forEach {
        it.binaries.framework {
            export(project(":core"))
            export(project(":stream"))
            baseName = "kbsky"
            xcf.add(this)
        }
    }

    cocoapods {
        name = "kbsky"
        version = "0.0.1"
        summary = "kbsky is Bluesky/ATProtocol library for Kotlin Multiplatform."
        homepage = "https://github.com/uakihir0/kbsky"
        authors = "Akihiro Urushihara"
        license = "MIT"
        framework { baseName = "kbsky" }
    }

    sourceSets {
        commonMain.dependencies {
            api(project(":core"))
            api(project(":stream"))
        }
    }
}

tasks.podPublishXCFramework {
    doLast {
        exec {
            executable = "sh"
            args = listOf("../tool/rename_podfile.sh")
        }
    }
}
