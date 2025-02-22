// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:4.1.1")
        classpath (Kotlin.gradle_plugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath (Libs.hilt_gradle_plugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://dl.bintray.com/arrow-kt/arrow-kt/") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}