plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
}

android {
    compileSdkVersion(AppConfig.compileSdkVersion)
    buildToolsVersion(AppConfig.buildTools)

    defaultConfig {

        buildConfigField("String", "BASE_URL", "\"https://rickandmortyapi.com/api/\"")

        applicationId = AppConfig.applicationId
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named(BuildType.Debug.name) {
            applicationIdSuffix = BuildType.Debug.applicationIdSuffix
            versionNameSuffix = BuildType.Debug.versionNameSuffix

            isMinifyEnabled = BuildType.Debug.isMinifyEnabled
            isTestCoverageEnabled = BuildType.Debug.isTestCoverageEnabled

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        named(BuildType.Release.name) {
            applicationIdSuffix = BuildType.Release.applicationIdSuffix
            versionNameSuffix = BuildType.Release.versionNameSuffix

            isMinifyEnabled = BuildType.Release.isMinifyEnabled
            isTestCoverageEnabled = BuildType.Release.isTestCoverageEnabled

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    viewBinding {
        android.buildFeatures.viewBinding = true
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

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //app libs
    implementation(appLibraries)
    androidTestImplementation(androidTestLibraries)
    testImplementation(testLibraries)
    kapt(annotationProcessors)
}