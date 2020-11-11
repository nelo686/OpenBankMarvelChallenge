plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(project(":domain"))
    implementation(Kotlin.stdlib)
    implementation(Kotlin.coroutines_core)
    implementation(Kotlin.coroutines)

    implementation(Libs.arrow_core)
    implementation(Libs.retrofit)

    testImplementation(TestLibs.junit)
    testImplementation(TestLibs.kluent)
    testImplementation(TestLibs.mockito_kotlin)
}
