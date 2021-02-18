plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfig.Android.compileSdk)
    buildToolsVersion = AppConfig.Android.buildTools

    defaultConfig {
        applicationId = "com.jcbmln.lurk"
        minSdkVersion(AppConfig.Android.minSdk)
        targetSdkVersion(AppConfig.Android.targetSdk)
        versionCode = 1
        versionName = "0.1.0"

        testInstrumentationRunner(AppConfig.Android.androidTestInstrumentation)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(AppConfig.Dependencies.Kotlin.core)
    implementation(AppConfig.Dependencies.Kotlin.coroutines)
    implementation(AppConfig.Dependencies.Kotlin.coroutinesAndroid)

    implementation(AppConfig.Dependencies.AndroidX.appcompat)
    implementation(AppConfig.Dependencies.AndroidX.recyclerView)
    implementation(AppConfig.Dependencies.AndroidX.constraintLayout)
    implementation(AppConfig.Dependencies.AndroidX.preference)
    implementation(AppConfig.Dependencies.AndroidX.lifecycle)
    implementation(AppConfig.Dependencies.AndroidX.lifecycleViewModel)
    implementation(AppConfig.Dependencies.AndroidX.lifecycleLiveData)
    implementation(AppConfig.Dependencies.AndroidX.navigation)
    implementation(AppConfig.Dependencies.AndroidX.navigationFragment)
    implementation(AppConfig.Dependencies.AndroidX.navigationUi)

    implementation(AppConfig.Dependencies.Google.material)

    implementation(AppConfig.Dependencies.Dagger.dagger)
    kapt(AppConfig.Dependencies.Dagger.daggerCompiler)

    implementation(AppConfig.Dependencies.Dagger.hilt)
    kapt(AppConfig.Dependencies.Dagger.hiltCompiler)

    implementation(AppConfig.Dependencies.AndroidX.hiltLifecycleViewModel)
    kapt(AppConfig.Dependencies.AndroidX.hiltCompiler)

    implementation(AppConfig.Dependencies.Square.moshi)
    kapt(AppConfig.Dependencies.Square.moshiCodegen)

    implementation(AppConfig.Dependencies.Square.okhttp)
    implementation(AppConfig.Dependencies.Square.retrofit)
    implementation(AppConfig.Dependencies.Square.moshiConverter)

    implementation(AppConfig.Dependencies.Misc.timber)
    implementation(AppConfig.Dependencies.Misc.overlappingPanels)

    testImplementation(AppConfig.Dependencies.Tests.junit)
    testImplementation(AppConfig.Dependencies.Tests.mockk)
    testImplementation(AppConfig.Dependencies.Tests.assertJ)

    testImplementation(AppConfig.Dependencies.Tests.spek)
    testImplementation(AppConfig.Dependencies.Tests.spekJunit)

    testImplementation(AppConfig.Dependencies.Square.okhttpMockWebserver)
}
