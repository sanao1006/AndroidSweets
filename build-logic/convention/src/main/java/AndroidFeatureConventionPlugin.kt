import app.sanao1006.androidsweets.libs
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("androidsweets.android.library")
                apply("androidsweets.android.hilt")
            }
            extensions.configure<LibraryExtension>{
                testOptions.animationsDisabled = true
            }
            dependencies {
                add("implementation", project(":core:ui"))
                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())

            }
        }
    }
}
