object Kotlin {
    const val version = "1.4.10"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    const val gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
}

object Android {
    const val applicationId = "es.dgr.obmarvel"

    const val minSdkVersion = 23
    const val targetSdkVersion = 30
    const val compileSdkVersion = 30
    const val buildToolsVersion = "29.0.3"

    /* APP */
    private const val versionMajor = 0 // Max 9
    private const val versionMinor = 0 // Max 9
    private const val versionPatch = 0 // Max 9
    private const val versionBuild = 1  // Max 99

    const val versionCode = versionMajor * 10000 + versionMinor * 1000 + versionPatch * 100 + versionBuild
    const val versionName = "${versionMajor}.${versionMinor}.${versionPatch}.${versionBuild}"
}

private object Version {
    // Android libs
    const val app_compat = "1.2.0"
    const val constraintLayout = "2.0.4"
    const val core_ktx = "1.3.2"
    const val material = "1.2.1"

    // Third party libs
    const val arrow_core = "0.11.0"
    const val coil = "1.0.0"
    const val coroutines = "1.4.1"
    const val hilt = "2.29-alpha"
    const val hilt_androidx = "1.0.0-alpha02"
    const val moshi = "1.11.0"
    const val okhttp3 = "4.9.0"
    const val retrofit = "2.9.0"

    // Test libs
    const val espresso_core = "3.3.0"
    const val junit = "4.13.1"
    const val junit_ext = "1.1.2"
}

object AndroidLibs {
    const val app_compat = "androidx.appcompat:appcompat:${Version.app_compat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val core_ktx = "androidx.core:core-ktx:${Version.core_ktx}"
    const val material = "com.google.android.material:material:${Version.material}"
}

object Libs {
    const val arrow_core = "io.arrow-kt:arrow-core:${Version.arrow_core}"
    const val coil = "io.coil-kt:coil:${Version.coil}"
    const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hilt_gradle_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
    const val hilt_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Version.hilt_androidx}"
    const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
    const val hilt_compiler_androidx = "androidx.hilt:hilt-compiler:${Version.hilt_androidx}"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Version.okhttp3}"
    const val okhttp3_interceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3}"
    const val moshi = "com.squareup.moshi:moshi:${Version.moshi}"
    const val moshi_codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Version.moshi}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val retrofit_converter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
}

object TestLibs {
    const val espresso_core = "androidx.test.espresso:espresso-core:${Version.espresso_core}"
    const val junit = "junit:junit:${Version.junit}"
    const val junit_ext = "androidx.test.ext:junit:${Version.junit_ext}"
}