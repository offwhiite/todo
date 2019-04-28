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
    }
}