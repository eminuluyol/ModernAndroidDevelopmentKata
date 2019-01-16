import Versions.androidEspressoVersion
import Versions.androidTestRunnerVersion
import Versions.constraintLayoutVersion
import Versions.coroutinesVersion
import Versions.jUnitVersion
import Versions.ktxVersion
import Versions.lifecycleExtensionVersion
import Versions.supportVersion

object CoreLibraries {
  val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
  val appcompat = "androidx.appcompat:appcompat:$supportVersion"
  val constraintLayout = "com.android.support.constraint:constraint-layout:$constraintLayoutVersion"
  val lifeCycleExtension = "android.arch.lifecycle:extensions:$lifecycleExtensionVersion"
  val lifeCycleCompiler = "android.arch.lifecycle:compiler:$lifecycleExtensionVersion"
  val courotinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
  val courotinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
  val andoroidKTX = "androidx.core:core-ktx:$ktxVersion"
}

object Libs {
}

object TestLibraries {
  val junit = "junit:junit:$jUnitVersion"
  val testRunner = "com.android.support.test:runner:$androidTestRunnerVersion"
  val espresso = "com.android.support.test.espresso:espresso-core:$androidEspressoVersion"
}