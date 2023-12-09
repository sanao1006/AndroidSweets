package io.github.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.network.remote.AndroidSweetsDataSource
import io.github.network.remote.AndroidSweetsNetworkApi

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
    @Binds
    fun binds(impl: AndroidSweetsNetworkApi): AndroidSweetsDataSource
}
