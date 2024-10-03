plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.nexus.publish)
    implementation(libs.maven.publish)
    implementation(libs.dokka)
}