package io.github.data.repository

import io.github.network.model.IssuesResponse
import io.github.network.model.MilestoneResponse
import io.github.network.remote.AndroidSweetsNetwork
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GithubServiceRepositoryImpl @Inject constructor(
    private val androidSweetsNetwork: AndroidSweetsNetwork
) : GithubServiceRepository {
    override fun getLatestMilestone(): Flow<MilestoneResponse> {
        TODO("Not yet implemented")
    }

    override fun getMilestone(milestoneId: String): Flow<MilestoneResponse> {
        TODO("Not yet implemented")
    }

    override fun getIssuesForMilestone(milestoneNum: String): Flow<IssuesResponse> {
        TODO("Not yet implemented")
    }
}
