object AppConfig {
    object Plugin {
        const val gradle = "com.android.tools.build:gradle:${Dependencies.Gradle.version}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.Kotlin.version}"
    }

    object Android {
        const val compileSdk = 30
        const val minSdk = 23
        const val targetSdk = 30
        const val buildTools = "29.0.3"
        const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Dependencies {
        object Gradle {
            const val version = "4.1.2"
        }

        object Kotlin {
            const val version = "1.4.30"
            const val core = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${version}"
            const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${version}"

            private const val coroutinesVersion = "1.4.2"
            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}"
            const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${coroutinesVersion}"
            const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${coroutinesVersion}"
        }

        object AndroidX {
            const val appcompat = "androidx.appcompat:appcompat:1.2.0"
            const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
            const val preference = "androidx.preference:preference-ktx:1.1.1"

            private const val lifecycleVersion = "2.3.0"
            const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${lifecycleVersion}"
            const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycleVersion}"
            const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${lifecycleVersion}"

            private const val navigationVersion = "2.3.3"
            const val navigation = "androidx.navigation:navigation-runtime-ktx:${navigationVersion}"
            const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${navigationVersion}"
            const val navigationUi = "androidx.navigation:navigation-ui-ktx:${navigationVersion}"

            private const val hiltVersion = "1.0.0-alpha02"
            const val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${hiltVersion}"
            const val hiltCompiler = "androidx.hilt:hilt-compiler:${hiltVersion}"
        }

        object Google {
            const val material = "com.google.android.material:material:1.3.0"
        }

        object Dagger {
            private const val version = "2.28.1"
            private const val hiltVersion = "2.28.1-alpha"

            const val dagger = "com.google.dagger:dagger:${version}"
            const val daggerCompiler = "com.google.dagger:dagger-compiler:${version}"

            const val hilt = "com.google.dagger:hilt-android:${hiltVersion}"
            const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${hiltVersion}"
        }

        object Square {
            private const val okhttpVersion = "4.7.2"
            const val okhttp = "com.squareup.okhttp3:${okhttpVersion}"
            const val okhttpMockWebserver = "com.squareup.okhttp3:mockwebserver:${okhttpVersion}"

            private const val retrofitVersion = "2.9.0"
            const val retrofit = "com.squareup.retrofit2:retrofit:${retrofitVersion}"
            const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${retrofitVersion}"

            private const val moshiVersion = "1.9.3"
            const val moshi = "com.squareup.moshi:moshi-kotlin:${moshiVersion}"
            const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${moshiVersion}"
        }

        object Misc {
            const val timber = "com.jakewharton.timber:timber:4.7.1"
            const val overlappingPanels = "com.github.discord:OverlappingPanels:0.1.2"
        }

        object Tests {
            const val junit = "junit:junit:4.13"
            const val mockk = "io.mockk:mockk:1.10.0"
            const val assertJ = "org.assertj:assertj-core:3.16.1"

            private const val spekVersion = "2.0.8"
            const val spek = "org.spekframework.spek2:spek-dsl-jvm:${spekVersion}"
            const val spekJunit = "org.spekframework.spek2:spek-runner-junit5:${spekVersion}"
        }
    }



}
