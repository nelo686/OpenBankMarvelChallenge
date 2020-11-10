plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(project(":domain"))
    implementation(Kotlin.stdlib)

    implementation(Libs.arrow_core)
}
