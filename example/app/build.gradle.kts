plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.apollographql.apollo")
    id("kotlin-kapt")
    id("realm-android")
}

android {
    namespace = "com.example.gi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.gi"
        minSdk = 24
        targetSdk = 34
        versionCode = 2
        versionName = "1.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }

    flavorDimensions.add("build")
    productFlavors {
        create("local") {
            dimension = "build"
        }

        create("remote") {
            dimension = "build"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    "localImplementation"(files("../../gi40lib.aar"))
    "localImplementation"("androidx.core:core-ktx:1.12.0")
    "localImplementation"("androidx.appcompat:appcompat:1.6.1")
    "localImplementation"("com.google.android.material:material:1.11.0")
    "localApi"("com.android.volley:volley:1.2.1")
    "localImplementation"("com.apollographql.apollo:apollo-runtime:2.5.14")
    "localImplementation"("com.apollographql.apollo:apollo-coroutines-support:2.5.14")
    "localImplementation"("com.journeyapps:zxing-android-embedded:4.3.0")
    "localImplementation"("com.github.matomo-org:matomo-sdk-android:4.1.4")
    "localImplementation"("com.google.code.gson:gson:2.10.1")
    "localImplementation"("androidx.browser:browser:1.7.0")
    "localImplementation"("com.github.bumptech.glide:glide:4.16.0")

    "remoteImplementation"("com.github.GI4-0:GI4.0-Library-Android:latest.release")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}