package io.github.data.repository

import io.github.network.model.IssuesResponse
import io.github.network.model.MilestoneResponse
import kotlinx.coroutines.flow.Flow

interface GithubServiceRepository {
    fun getLatestMilestone(): Flow<MilestoneResponse>

    fun getMilestone(milestoneId: String): Flow<MilestoneResponse>

    fun getIssuesForMilestone(milestoneNum: String): Flow<IssuesResponse>
}
