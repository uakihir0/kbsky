import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    id("module.publications")
}

kotlin {
    jvmToolchain(11)
    jvm()

    js(IR) {
        nodejs()
        browser()

        compilations.all {
            compileTaskProvider.configure {
                compilerOptions { target.set("es2015") }
            }
        }
    }

    if (HostManager.hostIsMac) {
        iosX64()
        iosArm64()
        iosSimulatorArm64()
        macosX64()
        macosArm64()
    }

    mingwX64()
    // linuxX64()

    compilerOptions {
        freeCompilerArgs.add("-Xenable-suspend-function-exporting")
    }

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }

        commonMain.dependencies {
            implementation(project(":core"))
            implementation(libs.ktor.core)
            implementation(libs.khttpclient)
            implementation(libs.coroutines.core)
            implementation(libs.serialization.json)
            implementation(libs.serialization.cbor)
        }

        // for test (kotlin/jvm)
        jvmTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.slf4j.simple)
        }
    }
}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}

