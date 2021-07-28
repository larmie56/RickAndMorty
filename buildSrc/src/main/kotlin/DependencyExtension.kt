import org.gradle.api.artifacts.dsl.DependencyHandler

val appLibraries = arrayListOf<String>().apply {
    add(Library.coreKtx)
    add(Library.appCompat)
    add(Library.constraintLayout)
    add(Library.fragment)
    add(Library.recyclerView)
    add(Library.navigationFragmentKtx)
    add(Library.navigationUiKtx)
    add(Library.room)
    add(Library.androidxJUnit)
    add(Library.viewModel)
    add(Library.material)
    add(Library.coroutines)
    add(Library.okhttp)
    add(Library.loggingInterceptor)
    add(Library.retrofit)
    add(Library.retrofitMoshi)
    add(Library.moshi)
    add(Library.glide)
    add(Library.circleImageView)
}

val androidTestLibraries = arrayListOf<String>().apply {
    add(Library.extJUnit)
    add(Library.espresso)
}

val testLibraries = arrayListOf<String>().apply {
    add(Library.junit)
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}