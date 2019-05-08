package dependencies
object Dep {
    object AndroidX {
        object Navigation {
            val version = "1.0.0-alpha08"
            val runtime = "android.arch.navigation:navigation-runtime:${dependencies.Dep.AndroidX.Navigation.version}"
            val runtimeKtx = "android.arch.navigation:navigation-runtime-ktx:${dependencies.Dep.AndroidX.Navigation.version}"
            val fragment = "android.arch.navigation:navigation-fragment:${dependencies.Dep.AndroidX.Navigation.version}"
            val ui = "android.arch.navigation:navigation-ui:${dependencies.Dep.AndroidX.Navigation.version}"
            val fragmentKtx = "android.arch.navigation:navigation-fragment-ktx:${dependencies.Dep.AndroidX.Navigation.version}"
            val uiKtx = "android.arch.navigation:navigation-ui-ktx:${dependencies.Dep.AndroidX.Navigation.version}"
        }

        object Kotlin {
            val version = "1.3.20"
            val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:$version"
            val stdlibJvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
            val coroutinesVersion = "1.2.0"
            val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
            val androidCoroutinesDispatcher =
                    "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
            val coroutinesReactive =
                    "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:$coroutinesVersion"
            val coroutinesPlayServices =
                    "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion"
            val serializationCommon = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.10.0"
            val serializationIos = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:0.10.0"
        }

        object ViewModel {
            val lifecycle_version = "2.1.0-alpha04"
            val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
            val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
            val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
        }
    }
}