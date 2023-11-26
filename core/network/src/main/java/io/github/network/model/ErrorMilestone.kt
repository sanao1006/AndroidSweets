package io.github.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorMilestone(
    @SerialName("documentation_url")
    val documentationUrl: String,
    @SerialName("message")
    val message: String
)