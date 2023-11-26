package io.github.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Reactions(
    @SerialName("confused")
    val confused: Int,
    @SerialName("eyes")
    val eyes: Int,
    @SerialName("heart")
    val heart: Int,
    @SerialName("hooray")
    val hooray: Int,
    @SerialName("laugh")
    val laugh: Int,
    @SerialName("rocket")
    val rocket: Int,
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("url")
    val url: String,
    @SerialName("+1")
    val x: Int,
    @SerialName("-1")
    val y: Int
)
