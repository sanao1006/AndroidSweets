@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("androidsweets.android.library")
    id("androidsweets.android.hilt")
    id("androidsweets.spotless")

    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "io.github.network"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    implementation(libs.retrofit.core)

    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.eithernet)
    implementation(libs.okhttp.logging)

    testImplementation(libs.mockk)
    testImplementation(libs.truth)
}