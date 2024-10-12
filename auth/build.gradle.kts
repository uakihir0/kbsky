plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    id("module.publications")
}

kotlin {
    jvmToolchain(11)

    jvm { withJava() }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosX64()
    macosArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(project(":core"))
            implementation(libs.ktor.core)
            implementation(libs.khttpclient)
            implementation(libs.datetime)
            implementation(libs.coroutines.core)
            implementation(libs.serialization.json)

            implementation(project.dependencies.platform(libs.cryptography.bom))
            implementation(libs.cryptography.core)
        }

        appleMain.dependencies {
            implementation(libs.cryptography.openssl)
        }

        // for test (kotlin/jvm)
        jvmTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.kotest.junit5)
            implementation(libs.kotest.assertions)
            implementation(libs.cryptography.jdk)
        }
    }
}


tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}