package io.github.network.remote

import com.slack.eithernet.ApiResult
import com.slack.eithernet.DecodeErrorBody
import io.github.network.model.ErrorIssue
import io.github.network.model.ErrorMilestone
import io.github.network.model.IssuesResponse
import io.github.network.model.MilestoneResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AndroidSweetsNetworkApi {
    @DecodeErrorBody
    @GET("milestones")
    suspend fun getLatestMilestone(): ApiResult<List<MilestoneResponse>, ErrorMilestone>

    @DecodeErrorBody
    @GET("milestones/{milestone_id}")
    suspend fun getMilestone(
        @Path("milestone_id") milestoneId: String
    ): ApiResult<MilestoneResponse, ErrorMilestone>

    @DecodeErrorBody
    @GET("issues")
    suspend fun getIssuesForMilestone(
        @Query("milestone") milestoneId: String
    ): ApiResult<List<IssuesResponse>, ErrorIssue>
}
