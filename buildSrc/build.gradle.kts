plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

object Plugin {

    object Version {
        const val androidGradle: String = "4.2.2"
        const val kotlin: String = "1.5.21"
        const val safeArgs: String = "2.3.3"
    }

    const val androidGradle: String = "com.android.tools.build:gradle:${Version.androidGradle}"
    const val kotlin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val safeArgs: String = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.safeArgs}"
}

dependencies {
    implementation(Plugin.androidGradle)
    implementation(Plugin.kotlin)
    implementation(Plugin.safeArgs)
}