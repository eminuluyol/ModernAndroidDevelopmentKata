plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kotlinKapt)
    id(Plugins.safeArgs)
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Release.versionCode
        versionName = Release.versionName
        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    flavorDimensions("build")
    productFlavors {
        create("dev") {
            buildConfigField("String", "API_URL", ProductFlavors.devBaseUrl)
        }

        create("prod") {
            buildConfigField("String", "API_URL", "")
        }
    }

    sourceSets {
        getByName("debug").res.srcDirs("$rootDir/core/src/main/sharedRes")
    }
}

androidExtensions {
    isExperimental = true
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.movies))
    implementation(project(Modules.tvseries))
    implementation(project(Modules.favourites))
    implementation(project(Modules.profile))
    implementation(project(Modules.details))
    implementation(project(Modules.similarmovies))

    kapt(CoreLibraries.lifeCycleAnnotationProcessor)
    kapt(ExternalLibraries.daggerAnnotationProcessor)
    kapt(ExternalLibraries.daggerCompiler)
    kapt(CoreLibraries.roomAnnotationProcessor)
    /**
     * Stetho
     */
    implementation(ExternalLibraries.stetho)
    /**
     * Test
     */
    testImplementation(TestLibraries.junit)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}
