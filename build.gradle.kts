buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(ClassPaths.gradleClasspath)
        classpath(ClassPaths.kotlinGradlePluginClasspath)
        classpath(ClassPaths.safeArgsClasspath)
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
