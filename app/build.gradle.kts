plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Android.compileSdkVersion)
    buildToolsVersion = Android.buildToolsVersion

    defaultConfig {
        applicationId = Android.applicationId
        minSdkVersion(Android.minSdkVersion)
        targetSdkVersion(Android.targetSdkVersion)
        versionCode = Android.versionCode
        versionName = Android.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField ("String", "BASE_URL", "\"https://gateway.marvel.com:443/\"")
        buildConfigField ("String", "PUBLIC_API_KEY", "\"4eaf5f44be3cac7577d71195c00f5afa\"")
        buildConfigField ("String", "PRIVATE_API_KEY", "\"f3a20441ebe46366d46941c346061caa908c0c9a\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(project(":usecases"))
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(Kotlin.stdlib)
    implementation(Kotlin.coroutines_core)
    implementation(Kotlin.coroutines)

    implementation(AndroidLibs.core_ktx)
    implementation(AndroidLibs.app_compat)
    implementation(AndroidLibs.material)
    implementation(AndroidLibs.constraintLayout)

    implementation(Libs.arrow_core)
    implementation(Libs.coil)
    implementation(Libs.hilt)
    implementation(Libs.hilt_viewmodel)
    kapt(Libs.hilt_compiler)
    kapt(Libs.hilt_compiler_androidx)

    implementation(Libs.okhttp3)
    implementation(Libs.okhttp3_interceptor)
    implementation(Libs.retrofit)
    implementation(Libs.retrofit_converter)

    testImplementation(TestLibs.junit)

    androidTestImplementation(TestLibs.junit_ext)
    androidTestImplementation(TestLibs.espresso_core)
}

kapt {
    correctErrorTypes = true
}