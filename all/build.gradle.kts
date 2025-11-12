import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.swiftpackage)
    id("module.publications")
}

kotlin {
    jvmToolchain(11)
    jvm()

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

multiplatformSwiftPackage {
    swiftToolsVersion("5.7")
    targetPlatforms {
        // baseline 2020
        iOS { v("15") }
        macOS { v("12.0") }
    }
}

tasks.configureEach {
    // Fix implicit dependency between XCFramework and FatFramework tasks
    if (name.contains("assembleKbsky") && name.contains("XCFramework")) {
        mustRunAfter(tasks.matching { it.name.contains("FatFramework") })
    }
}

tasks.podPublishXCFramework {
    doLast {
        providers.exec {
            executable = "sh"
            args = listOf(project.projectDir.path + "/../tool/rename_podfile.sh")
        }.standardOutput.asText.get()
    }
}