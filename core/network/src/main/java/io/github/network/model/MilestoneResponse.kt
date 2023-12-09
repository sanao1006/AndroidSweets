package io.github.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MilestoneResponse(
//    @SerialName("closed_at")
//    val closedAt: String?,
//    @SerialName("closed_issues")
//    val closedIssues: Int,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("creator")
    val creator: Creator,
    @SerialName("description")
    val description: String?,
//    @SerialName("due_on")
//    val dueOn: String,
    @SerialName("html_url")
    val htmlUrl: String,
    @SerialName("id")
    val id: Int,
    @SerialName("labels_url")
    val labelsUrl: String,
    @SerialName("node_id")
    val nodeId: String,
    @SerialName("number")
    val number: Int,
    @SerialName("open_issues")
    val openIssues: Int,
//    @SerialName("state")
//    val state: String,
    @SerialName("title")
    val title: String,
//    @SerialName("updated_at")
//    val updatedAt: String,
    @SerialName("url")
    val url: String
)

fun MilestoneResponse.toMilestone(): Milestone {
    return Milestone(
        createdAt = this.createdAt,
        creator = this.creator,
        description = this.description ?: "",
        htmlUrl = this.htmlUrl,
        id = this.id,
        labelsUrl = this.labelsUrl,
        nodeId = this.nodeId,
        number = this.number,
        openIssues = this.openIssues,
        title = this.title,
        url = this.url
    )
}
