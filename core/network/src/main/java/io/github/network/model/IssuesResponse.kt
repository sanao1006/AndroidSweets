package io.github.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IssuesResponse(
    @SerialName("active_lock_reason")
    val activeLockReason: String?,
    @SerialName("assignee")
    val assignee: String?,
    @SerialName("assignees")
    val assignees: List<String?>,
    @SerialName("author_association")
    val authorAssociation: String,
    @SerialName("body")
    val body: String,
    @SerialName("closed_at")
    val closedAt: String?,
    @SerialName("comments")
    val comments: Int,
    @SerialName("comments_url")
    val commentsUrl: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("events_url")
    val eventsUrl: String,
    @SerialName("html_url")
    val htmlUrl: String,
    @SerialName("id")
    val id: Int,
    @SerialName("labels")
    val labels: List<Label>,
    @SerialName("labels_url")
    val labelsUrl: String,
    @SerialName("locked")
    val locked: Boolean,
    @SerialName("milestone")
    val milestone: Milestone,
    @SerialName("node_id")
    val nodeId: String,
    @SerialName("number")
    val number: Int,
//    @SerialName("performed_via_github_app")
    val performedViaGithubApp: String?,
    @SerialName("reactions")
    val reactions: Reactions,
    @SerialName("repository_url")
    val repositoryUrl: String,
    @SerialName("state")
    val state: String,
//    @SerialName("state_reason")
    val stateReason: String?,
    @SerialName("timeline_url")
    val timelineUrl: String,
    @SerialName("title")
    val title: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("url")
    val url: String,
    @SerialName("user")
    val user: User
)

fun IssuesResponse.toIssue(): Issue {
    return Issue(
        assignee = this.assignee,
        assignees = this.assignees,
        body = this.body,
        createdAt = this.createdAt,
        eventsUrl = this.eventsUrl,
        htmlUrl = this.htmlUrl,
        id = this.id,
        labels = this.labels,
        labelsUrl = this.labelsUrl,
        milestone = this.milestone,
        nodeId = this.nodeId,
        number = this.number
    )
}
