// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        maven {
            url = java.net.URI("https://jitpack.io")
        }
        maven {
            url = java.net.URI("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${AppConfig.Dependencies.Gradle.version}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${AppConfig.Dependencies.Kotlin.version}")
        classpath("de.mannodermaus.gradle.plugins:android-junit5:1.6.2.0")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:9.1.1")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.28.1-alpha")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            url = java.net.URI("https://jitpack.io")
        }
        maven {
            url = java.net.URI("https://plugins.gradle.org/m2/")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
