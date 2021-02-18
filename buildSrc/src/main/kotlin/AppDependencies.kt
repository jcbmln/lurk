import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    // app libraries
    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    private const val coreKtx = "androidx.core:core-ktx:1.3.2"
    private const val appCompat = "androidx.appcompat:appcompat:1.2.0"
    private const val material = "com.google.android.material:material:1.3.0"
    private const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"

    // test libraries
    private const val junit = "junit:junit:4.13.2"

    // android test libraries
    private const val extJunit = "androidx.test.ext:junit:1.1.2"
    private const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(appCompat)
        add(material)
        add(constraintLayout)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJunit)
        add(espressoCore)
    }

    fun DependencyHandler.kapt(dependencies: List<String>) {
        for (dependency in dependencies) {
            add("kapt", dependency)
        }
    }

    fun DependencyHandler.implementation(dependencies: List<String>) {
        for (dependency in dependencies) {
            add("implementation", dependency)
        }
    }

    fun DependencyHandler.testImplementation(dependencies: List<String>) {
        for (dependency in dependencies) {
            add("testImplementation", dependency)
        }
    }

    fun DependencyHandler.androidTestImplementation(dependencies: List<String>) {
        for (dependency in dependencies) {
            add("androidTestImplementation", dependency)
        }
    }
}
