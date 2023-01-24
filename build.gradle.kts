//plugins {
//    //trick: for the same plugin versions in all sub-modules
//    id("com.android.application").version("7.2.1").apply(false)
//    id("com.android.library").version("7.2.1").apply(false)
//    kotlin("android").version("1.7.10").apply(false)
//    kotlin("multiplatform").version("1.7.10").apply(false)
//}
//
//buildscript {
//    val sqlDelightVersion = "1.5.4"
//    dependencies {
//        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
////        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
//    }
//}
//
//tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
//}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.4")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}