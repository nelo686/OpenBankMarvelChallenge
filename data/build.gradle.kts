plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(project(":domain"))
    implementation(Kotlin.stdlib)

    implementation(Libs.arrow_core)
    implementation(Libs.okhttp3)
    implementation(Libs.okhttp3_interceptor)
    implementation(Libs.retrofit)
}
