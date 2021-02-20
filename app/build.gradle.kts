import java.io.ByteArrayOutputStream

plugins {
    id("com.android.application")
    id("org.jlleitschuh.gradle.ktlint")
    id("de.mannodermaus.android-junit5")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

fun gitTag(): String {
    return ByteArrayOutputStream().use { out ->
        project.exec {
            commandLine("git", "describe", "--tags", "--abbrev=0")
            standardOutput = out
        }
        out.toString()
    }
}

fun gitCommitCount(): Int {
    return ByteArrayOutputStream().use { out ->
        project.exec {
            commandLine("git", "rev-list", "--count", "HEAD")
            standardOutput = out
        }
        Integer.parseInt(out.toString().trim())
    }
}

android {
    compileSdkVersion(AppConfig.Android.compileSdk)
    buildToolsVersion = AppConfig.Android.buildTools

    defaultConfig {
        applicationId = "com.jcbmln.lurk"
        minSdkVersion(AppConfig.Android.minSdk)
        targetSdkVersion(AppConfig.Android.targetSdk)
        versionCode = System.getenv("VERSION_CODE").toIntOrNull() ?: 1
        versionName = System.getenv("VERSION_NAME") ?: "LOCAL"

        testInstrumentationRunner(AppConfig.Android.androidTestInstrumentation)
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    signingConfigs {
        create("release") {
            storeFile = file(System.getenv("KEYSTORE_PATH") ?: "releasekey.jks")
            storePassword = System.getenv("KEYSTORE_PASSWORD") ?: ""
            keyAlias = System.getenv("KEYSTORE_ALIAS") ?: ""
            keyPassword = System.getenv("KEYSTORE_ALIAS_PASSWORD") ?: ""
            isV1SigningEnabled = true
            isV2SigningEnabled = true
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

    lintOptions {
        warning("InvalidPackage")
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform {
            includeEngines("spek2")
        }
    }
}

ktlint {
    android.set(true)
    disabledRules.add("import-ordering")
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
