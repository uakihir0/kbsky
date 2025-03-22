import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    id("module.publications")
}

kotlin {
    jvmToolchain(11)

    jvm { withJava() }
    if (HostManager.hostIsMac) {
        iosX64()
        iosArm64()
        iosSimulatorArm64()
        macosX64()
        macosArm64()
    }

    sourceSets {
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
            implementation(libs.kotest.junit5)
            implementation(libs.kotest.assertions)
        }
    }
}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}

