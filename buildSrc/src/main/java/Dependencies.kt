import Versions.androidEspressoVersion
import Versions.androidTestRunnerVersion
import Versions.constraintLayoutVersion
import Versions.coroutinesVersion
import Versions.daggerVersion
import Versions.jUnitVersion
import Versions.kotlinVersion
import Versions.ktxVersion
import Versions.lifecycleExtensionVersion
import Versions.moshiVersion
import Versions.navVersion
import Versions.okhttpVersion
import Versions.pagingVersion
import Versions.retrofitCoroutinesAdapterVersion
import Versions.retrofitVersion
import Versions.roomVersion
import Versions.supportVersion

object CoreLibraries {
  val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
  val appcompat = "androidx.appcompat:appcompat:$supportVersion"
  val constraintLayout = "com.android.support.constraint:constraint-layout:$constraintLayoutVersion"
  val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
  val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
  val andoroidKTX = "androidx.core:core-ktx:$ktxVersion"
  val lifeCycleExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleExtensionVersion"
  val lifeCycleAnnotationProcessor = "androidx.lifecycle:lifecycle-compiler:$lifecycleExtensionVersion"
  val roomCore = "androidx.room:room-runtime:$roomVersion"
  val roomAnnotationProcessor =  "androidx.room:room-compiler:$roomVersion"
  val roomCoroutinesSupport =  "androidx.room:room-coroutines:$roomVersion"
  val paging = "androidx.paging:paging-runtime-ktx:$pagingVersion"
  val navigationFragment = "android.arch.navigation:navigation-fragment-ktx:$navVersion"
  val navigationUI = "android.arch.navigation:navigation-ui-ktx:$navVersion"
}

object ExternalLibraries {
  val daggerCore = "com.google.dagger:dagger:$daggerVersion"
  val daggerSupport = "com.google.dagger:dagger:$daggerVersion"
  val daggerAnnotationProcessor = "com.google.dagger:dagger-android-support:$daggerVersion"
  val retrofitCore = "com.squareup.retrofit2:retrofit:$retrofitVersion"
  val retrofitCoroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$retrofitCoroutinesAdapterVersion"
  val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
  val moshi = "com.squareup.moshi:moshi:$moshiVersion"
  val okhttp = "com.squareup.okhttp3:okhttp:$okhttpVersion"
  val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
}

object TestLibraries {
  val junit = "junit:junit:$jUnitVersion"
  val testRunner = "com.android.support.test:runner:$androidTestRunnerVersion"
  val espresso = "com.android.support.test.espresso:espresso-core:$androidEspressoVersion"
}