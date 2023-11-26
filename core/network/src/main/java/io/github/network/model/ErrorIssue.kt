package io.github.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorIssue(
    @SerialName("documentation_url")
    val documentationUrl: String,
    @SerialName("errors")
    val errors: List<Error>,
    @SerialName("message")
    val message: String
)