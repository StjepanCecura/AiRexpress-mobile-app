plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.example.scanner"
    compileSdk = 34

    defaultConfig {
        //applicationId = "com.example.scanner"
        minSdk = 28
        targetSdk = 34
        //versionCode = 1
        //versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation (project(":ws"))
    implementation (project(":qrcodescanner"))

    implementation ("androidx.camera:camera-camera2:1.3.0-alpha07")
    implementation ("androidx.camera:camera-lifecycle:1.3.0-alpha07")
    implementation ("androidx.camera:camera-view:1.3.0-alpha07")
    implementation ("androidx.camera:camera-extensions:1.3.0-alpha07")

    implementation ("com.google.accompanist:accompanist-permissions:0.33.2-alpha")
    implementation("androidx.compose.material:material:1.5.4")

    implementation("androidx.navigation:navigation-compose:2.7.5")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")



}