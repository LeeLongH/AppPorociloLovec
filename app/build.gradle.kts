import org.gradle.kotlin.dsl.libs

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //kotlin("plugin.serialization") version "2.1.0"
    id("com.google.devtools.ksp")
    //id("androidx.room") // Add the Room plugin here

}

android {
    namespace = "com.example.porocilolovec"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.porocilolovec"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Schema export configuration goes here
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                )
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    //implementation(libs.okhttp)
    //implementation 'com.google.android.gms:play-services-speech:21.0.1'
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Room
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.runtime) // obvezna knjižnica
    implementation(libs.androidx.room.ktx) // opcijsko, za coroutines podporo

    //API
    implementation(libs.okhttp) // Uses OkHttp version 4.10.0
    //implementation(libs.okhttp.v4110) // Uses OkHttp version 4.11.0

    //json
    implementation(libs.kotlinx.serialization.json)


    implementation (libs.gson.v288)

}