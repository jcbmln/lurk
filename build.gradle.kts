// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        maven {
            url = java.net.URI("https://jitpack.io")
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${AppConfig.Dependencies.Gradle.version}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${AppConfig.Dependencies.Kotlin.version}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
