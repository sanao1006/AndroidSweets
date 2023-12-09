package io.github.network.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.slack.eithernet.ApiResult
import com.slack.eithernet.ApiResultCallAdapterFactory
import com.slack.eithernet.ApiResultConverterFactory
import com.slack.eithernet.DecodeErrorBody
import io.github.network.RequestHelper
import io.github.network.model.ErrorIssue
import io.github.network.model.ErrorMilestone
import io.github.network.model.Issue
import io.github.network.model.IssuesResponse
import io.github.network.model.Milestone
import io.github.network.model.MilestoneResponse
import io.github.network.model.toIssue
import io.github.network.model.toMilestone
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

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

@Singleton
class AndroidSweetsNetWork @Inject constructor() : AndroidSweetsDataSource {
    val baseUrl = "https://api.github.com/repos/AndroidDagashi/AndroidDagashi/"
    val contentType = "application/json".toMediaType()
    val json = Json { ignoreUnknownKeys = true }
    private val api = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(ApiResultConverterFactory)
    .addCallAdapterFactory(ApiResultCallAdapterFactory)
    .addConverterFactory(json.asConverterFactory(contentType))
    .build()
    .create(AndroidSweetsNetworkApi::class.java)

    override suspend fun getLatestMilestone(): Milestone {
        return RequestHelper.executeMileStoneRequest { api.getLatestMilestone() }[0].toMilestone()
    }

    override suspend fun getMilestone(milestoneId: String): Milestone {
        return RequestHelper.executeMileStoneRequest { api.getMilestone(milestoneId = milestoneId) }.toMilestone()
    }

    override suspend fun getIssuesForMilestone(milestoneId: String): List<Issue> {
        return  RequestHelper.executeIssueRequest { api.getIssuesForMilestone(milestoneId = milestoneId) }.map { it.toIssue() }
    }
}
