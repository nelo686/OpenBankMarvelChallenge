plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(Kotlin.stdlib)
    implementation(Libs.arrow_core)
}
