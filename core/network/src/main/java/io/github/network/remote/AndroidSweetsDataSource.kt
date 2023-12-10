package io.github.network.remote

import io.github.network.model.Issue
import io.github.network.model.Milestone

interface AndroidSweetsDataSource {
    suspend fun getLatestMilestone(): Milestone
    suspend fun getMilestone(milestoneId: String): Milestone
    suspend fun getIssuesForMilestone(milestoneId: String): List<Issue>
}
