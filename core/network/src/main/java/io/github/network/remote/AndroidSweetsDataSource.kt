package io.github.network.remote

import io.github.network.model.IssuesResponse
import io.github.network.model.MilestoneResponse

interface AndroidSweetsDataSource {
    suspend fun getLatestMilestone(): List<MilestoneResponse>
    suspend fun getMilestone(milestoneId: String): MilestoneResponse
    suspend fun getIssuesForMilestone(milestoneId: String): List<IssuesResponse>
}