buildscript {

  repositories {
    google()
    jcenter()
    mavenCentral()
  }
  dependencies {
    classpath (ClassPaths.gradleClasspath)
    classpath (ClassPaths.kotlinGradlePluginClasspath)
    classpath (ClassPaths.safeArgsClasspath)

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle files
  }
}

allprojects {
  repositories {
    google()
    jcenter()
    mavenCentral()
  }
}

task<Delete>("clean") {
  delete(rootProject.buildDir)
}
