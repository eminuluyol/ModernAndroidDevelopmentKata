import Versions.gradleVersion
import Versions.kotlinVersion
import Versions.navVersion

object ClassPaths {
  const val gradleClasspath = "com.android.tools.build:gradle:$gradleVersion"
  const val kotlinGradlePluginClasspath = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
  const val safeArgsClasspath = "androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion"
}
