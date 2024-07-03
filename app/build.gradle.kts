import org.jetbrains.kotlin.utils.addToStdlib.butIf
ksp {
    arg("option_name", "option_value")
}

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.services)

    //Hilt
    alias(libs.plugins.hilt.pluggin)
    alias(libs.plugins.ksp.pluggin)

    //Compose Compiler
    alias(libs.plugins.compose.compiler)

}

android {
    namespace = "com.meianoitedev.carshop"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.meianoitedev.carshop"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig =  true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    //Okhttp
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.interceptor)

    //Dagger Hilt
    implementation(libs.dagger.hilt)
    implementation(libs.firebase.crashlytics.buildtools)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    //ComposeNavigation
    implementation(libs.compose.navigation)
    implementation(libs.compose.navigation.ui)
    implementation(libs.compose.fragment)
    implementation(libs.compose.suport)

    //Kotlin Serialization
    implementation(libs.kotlin.serialization)

    //ComposeBottomNav
    implementation(libs.bottom.nav)

    //ComposeIconsExtended
    implementation(libs.compose.icons.extended)

    //FirebaseAuth
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)

    //Room
    implementation(libs.room.coroutines)
    ksp(libs.room.ksp)
    implementation(libs.room.lib)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}