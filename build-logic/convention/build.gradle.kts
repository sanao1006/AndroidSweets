@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    `kotlin-dsl`
    alias(libs.plugins.ktlint)
}

group = "app.sanao1006.androidsweets.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ktlint.plugin)
}

ktlint {
    version = libs.versions.ktlint.get()
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "androidsweets.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "androidsweets.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidHilt") {
            id = "androidsweets.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidKtLint") {
            id = "androidsweets.android.ktlint"
            implementationClass = "KtLintConventionPlugin"
        }
        register("androidLibrary") {
            id = "androidsweets.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "androidsweets.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>()
    .configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
