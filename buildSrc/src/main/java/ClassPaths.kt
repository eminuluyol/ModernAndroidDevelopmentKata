import Versions.gradleVersion
import Versions.kotlinVersion
import Versions.navVersion

object ClassPaths {
  val gradleClasspath = "com.android.tools.build:gradle:$gradleVersion"
  val kotlinGradlePluginClasspath = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
  val safeArgsClasspath = "android.arch.navigation:navigation-safe-args-gradle-plugin:$navVersion"
}