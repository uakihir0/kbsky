import org.gradle.api.tasks.compile.JavaCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    id("module.publications")
}

kotlin {
    jvm {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
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
    linuxX64()

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
            implementation(libs.cryptography.jdk)
            implementation(libs.slf4j.simple)
        }
    }
}


tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(11)
}
