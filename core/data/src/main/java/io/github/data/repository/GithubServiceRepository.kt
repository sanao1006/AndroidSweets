package io.github.data.repository

import io.github.network.model.Issue
import io.github.network.model.Milestone
import kotlinx.coroutines.flow.Flow

interface GithubServiceRepository {
    fun getLatestMilestone(): Flow<Milestone>

    fun getMilestone(milestoneId: String): Flow<Milestone>

    fun getIssuesForMilestone(milestoneNum: String): Flow<List<Issue>>
}
