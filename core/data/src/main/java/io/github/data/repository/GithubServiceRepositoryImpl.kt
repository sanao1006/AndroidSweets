package io.github.data.repository

import io.github.network.model.Issue
import io.github.network.model.Milestone
import io.github.network.remote.AndroidSweetsDataSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GithubServiceRepositoryImpl @Inject constructor(
    private val androidSweetsDataSource: AndroidSweetsDataSource
) : GithubServiceRepository {
    override fun getLatestMilestone(): Flow<Milestone> = flow {
        emit(androidSweetsDataSource.getLatestMilestone())
    }

    override fun getMilestone(milestoneId: String): Flow<Milestone> = flow {
        emit(androidSweetsDataSource.getMilestone(milestoneId = milestoneId))
    }

    override fun getIssuesForMilestone(milestoneNum: String): Flow<List<Issue>> = flow {
        emit(androidSweetsDataSource.getIssuesForMilestone(milestoneId = milestoneNum))
    }
}
