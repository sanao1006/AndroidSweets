package io.github.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.data.repository.GithubServiceRepository
import io.github.data.repository.GithubServiceRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindGithubServiceRepository(
        githubServiceRepositoryImpl: GithubServiceRepositoryImpl
    ): GithubServiceRepository
}
