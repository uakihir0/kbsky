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
            implementation(libs.hash.sha2)

                implementation(project.dependencies.platform("dev.whyoleg.cryptography:cryptography-bom:0.3.1"))
                implementation("dev.whyoleg.cryptography:cryptography-core")
        }

        appleMain.dependencies {
            implementation("dev.whyoleg.cryptography:cryptography-provider-openssl3-prebuilt")
        }

        // for test (kotlin/jvm)
        jvmTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.kotest.junit5)
            implementation(libs.kotest.assertions)
            implementation("dev.whyoleg.cryptography:cryptography-provider-jdk")

        }
    }
}


tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}