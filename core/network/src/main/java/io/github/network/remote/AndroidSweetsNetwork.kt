package io.github.network.remote

import com.slack.eithernet.ApiResult
import com.slack.eithernet.DecodeErrorBody
import io.github.network.model.ErrorIssue
import io.github.network.model.ErrorMilestone
import io.github.network.model.IssuesResponse
import io.github.network.model.MilestoneResponse
import okio.IOException
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AndroidSweetsNetwork {
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

    companion object {
        suspend fun <A : Any> execute(run: suspend () -> ApiResult<A, ErrorMilestone>): A {
            when (val res = run()) {
                is ApiResult.Success -> return res.value
                is ApiResult.Failure -> when (res) {
                    is ApiResult.Failure.HttpFailure -> throw IOException(res.error?.message)
                    is ApiResult.Failure.ApiFailure -> throw IOException(res.error?.message)
                    is ApiResult.Failure.NetworkFailure -> throw res.error
                    is ApiResult.Failure.UnknownFailure -> throw res.error
                }
            }
        }

        suspend fun <A : Any> execute(run: suspend () -> ApiResult<A, ErrorIssue>): A {
            when (val res = run()) {
                is ApiResult.Success -> return res.value
                is ApiResult.Failure -> when (res) {
                    is ApiResult.Failure.HttpFailure -> throw IOException(res.error?.message)
                    is ApiResult.Failure.ApiFailure -> throw IOException(res.error?.message)
                    is ApiResult.Failure.NetworkFailure -> throw res.error
                    is ApiResult.Failure.UnknownFailure -> throw res.error
                }
            }
        }
    }
}
