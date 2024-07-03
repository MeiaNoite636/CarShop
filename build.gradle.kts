// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    //Hilt
    alias(libs.plugins.hilt.pluggin) apply false
    alias(libs.plugins.ksp.pluggin) apply false

    //Compose compiler
    alias(libs.plugins.compose.compiler) apply false

    //Google Services
    alias(libs.plugins.google.services) apply false

    //Room
    alias(libs.plugins.room.plugin) apply false
}