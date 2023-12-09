package io.github.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.slack.eithernet.ApiResultCallAdapterFactory
import com.slack.eithernet.ApiResultConverterFactory
import io.github.network.RequestHelper
import io.github.network.model.Issue
import io.github.network.model.Milestone
import io.github.network.model.toIssue
import io.github.network.model.toMilestone
import io.github.network.remote.AndroidSweetsDataSource
import io.github.network.remote.AndroidSweetsNetworkApi
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

@Singleton
class AndroidSweetsNetwork @Inject constructor() : AndroidSweetsDataSource {
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
        return RequestHelper.executeMileStoneRequest { api.getMilestone(milestoneId = milestoneId) }
            .toMilestone()
    }

    override suspend fun getIssuesForMilestone(milestoneId: String): List<Issue> {
        return RequestHelper.executeIssueRequest {
            api.getIssuesForMilestone(milestoneId = milestoneId)
        }
            .map { it.toIssue() }
    }
}
