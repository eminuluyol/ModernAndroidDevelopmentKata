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
    applicationId = Config.applicatiınId
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

  androidExtensions {
    isExperimental = true
  }

  flavorDimensions("build")
  productFlavors {
    create("dev") {
      buildConfigField("String", "API_URL",  ProductFlavors.devBaseUrl)
    }

    create("prod") {
      buildConfigField("String", "API_URL", "")
    }
  }

}

dependencies {

  implementation(CoreLibraries.kotlin)

  implementation(CoreLibraries.appcompat)
  implementation(CoreLibraries.materialComponent)
  /**
   * ConstraintLayout
   */
  implementation(CoreLibraries.constraintLayout)
  /**
   * Coroutines
   */
  implementation(CoreLibraries.coroutinesCore)
  implementation(CoreLibraries.coroutinesAndroid)
  /**
   * AndroidKTX
   */
  implementation(CoreLibraries.andoroidKTX)
  /**
   * LiveData, ViewModel, LifeCycle
   */
  implementation(CoreLibraries.lifeCycleExtensions)
  kapt(CoreLibraries.lifeCycleAnnotationProcessor)
  /**
   * Paging
   */
  implementation(CoreLibraries.paging)
  /**
   * Navigation
   */
  implementation(CoreLibraries.navigationFragment)
  implementation(CoreLibraries.navigationUI)

  /**
   * Dagger2
   */
  implementation(ExternalLibraries.daggerCore)
  implementation(ExternalLibraries.daggerSupport)
  kapt(ExternalLibraries.daggerAnnotationProcessor)
  kapt(ExternalLibraries.daggerCompiler)
  /**
   * Retrofit
   */
  implementation(ExternalLibraries.retrofitCore)
  implementation(ExternalLibraries.retrofitCoroutinesAdapter)
  implementation(ExternalLibraries.retrofitMoshi)
  implementation(ExternalLibraries.moshi)
  implementation(ExternalLibraries.okhttp)
  implementation(ExternalLibraries.okhttpInterceptor)
  /**
   * Room
   */
  implementation(CoreLibraries.roomCore)
  kapt(CoreLibraries.roomAnnotationProcessor)
  implementation(CoreLibraries.roomCoroutinesSupport)
  /**
   * Test
   */
  testImplementation(TestLibraries.junit)
  androidTestImplementation(TestLibraries.testRunner)
  androidTestImplementation(TestLibraries.espresso)
}