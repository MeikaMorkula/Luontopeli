plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.luontopeli"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.luontopeli"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0.0"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Compose BOM — hallitsee Compose-kirjastojen versiot automaattisesti
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.material.icons.extended)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Firebase BOM (hallitsee versiot)
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))

    // Firebase Authentication
    implementation("com.google.firebase:firebase-auth-ktx")

    // Firebase Firestore
    implementation("com.google.firebase:firebase-firestore-ktx")

    // Firebase Storage
    implementation("com.google.firebase:firebase-storage-ktx")

    // Kotlin Coroutines support for Tasks (await)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")

    implementation("com.squareup:javapoet:1.13.0")

    implementation("com.google.android.gms:play-services-location:21.0.1")

    hilt {
        enableAggregatingTask = false
    }

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // Hilt (riippuvuusinjektio)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    // OpenStreetMap — kartat ilman API-avainta (lisätään viikolla 3)
    implementation(libs.osmdroid.android)

    // CameraX (lisätään viikolla 4)
    implementation(libs.camera.core)
    implementation(libs.camera.camera2)
    implementation(libs.camera.lifecycle)
    implementation(libs.camera.view)
    implementation(libs.camera.extensions)

    // Coil — kuvan lataus (lisätään viikolla 4)
    implementation(libs.coil.compose)

    // ML Kit — kasvintunnistus (lisätään viikolla 5)
    implementation(libs.mlkit.image.labeling)

    // Splash Screen (lisätään viikolla 7)
    implementation(libs.androidx.core.splashscreen)

    // Accompanist Permissions — ajonaikaiset luvat (lisätään viikolla 2–3)
    implementation(libs.accompanist.permissions)

    //debugImplementation(libs.androidx.compose.ui.tooling)
    testImplementation(kotlin("test"))
}