package io.github.network.model

data class Issue(
    val assignee: String?,
    val assignees: List<String?>,
    val body: String,
    val createdAt: String,
    val eventsUrl: String,
    val htmlUrl: String,
    val id: Int,
    val labels: List<Label>,
    val labelsUrl: String,
    val milestone: Milestone,
    val nodeId: String,
    val number: Int,
)
