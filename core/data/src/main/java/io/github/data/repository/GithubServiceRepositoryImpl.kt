package io.github.data.repository

import io.github.data.RequestHelper
import io.github.network.model.IssuesResponse
import io.github.network.model.MilestoneResponse
import io.github.network.remote.AndroidSweetsNetwork
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GithubServiceRepositoryImpl @Inject constructor(
    private val androidSweetsNetwork: AndroidSweetsNetwork,
) : GithubServiceRepository {
    override fun getLatestMilestone(): Flow<MilestoneResponse> = flow {
        emit(
            RequestHelper.executeMileStoneRequest { androidSweetsNetwork.getLatestMilestone() }[0]
        )
    }

    override fun getMilestone(milestoneId: String): Flow<MilestoneResponse> = flow {
        emit(
            RequestHelper.executeMileStoneRequest { androidSweetsNetwork.getMilestone(milestoneId) }
        )
    }

    override fun getIssuesForMilestone(milestoneNum: String): Flow<List<IssuesResponse>> = flow {
        emit(
            RequestHelper.executeIssueRequest {
                androidSweetsNetwork.getIssuesForMilestone(milestoneNum)
            }
        )
    }
}
