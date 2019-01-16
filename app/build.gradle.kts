import Config.testInstrumentationRunner
import Release.versionCode
import Release.versionName
import Versions.compileSdkVersion
import Versions.minSdkVersion
import Versions.targetSdkVersion
import com.android.build.gradle.ProguardFiles.getDefaultProguardFile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
  id(Plugins.androidApplication)
  id(Plugins.kotlinAndroid)
  id(Plugins.kotlinAndroidExtensions)
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
}

dependencies {

  implementation(CoreLibraries.kotlin)

  implementation(CoreLibraries.appcompat)
  implementation(CoreLibraries.constraintLayout)
  implementation(CoreLibraries.courotinesCore)
  implementation(CoreLibraries.courotinesAndroid)
  implementation(CoreLibraries.andoroidKTX)
  implementation(CoreLibraries.lifeCycleExtension)
  kapt(CoreLibraries.lifeCycleCompiler)

  testImplementation(TestLibraries.junit)
  androidTestImplementation(TestLibraries.testRunner)
  androidTestImplementation(TestLibraries.espresso)
}