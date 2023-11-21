import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jlleitschuh.gradle.ktlint.KtlintExtension

class KtLintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("org.jlleitschuh.gradle.ktlint")
        target.extensions.configure<KtlintExtension> {
            android.set(true)
        }
    }
}