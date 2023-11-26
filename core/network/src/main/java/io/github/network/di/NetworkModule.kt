package io.github.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.slack.eithernet.ApiResultCallAdapterFactory
import com.slack.eithernet.ApiResultConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.network.remote.AndroidSweetsNetwork
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideAndroidSweetsService() : AndroidSweetsNetwork {
        val baseUrl = "https://api.github.com/repos/AndroidDagashi/AndroidDagashi/"
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ApiResultConverterFactory)
            .addCallAdapterFactory(ApiResultCallAdapterFactory)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(AndroidSweetsNetwork::class.java)
    }
}