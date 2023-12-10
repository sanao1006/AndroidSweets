package io.github.network

import com.slack.eithernet.ApiResult
import io.github.network.model.ErrorIssue
import io.github.network.model.ErrorMilestone
import okio.IOException

object RequestHelper {
    // TODO: ジェネリクスをうまく使えばこれら２つの関数を１つにまとめることができる？
    suspend fun <A : Any> executeMileStoneRequest(
        run: suspend () -> ApiResult<A, ErrorMilestone>
    ): A {
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

    suspend fun <A : Any> executeIssueRequest(
        run: suspend () -> ApiResult<A, ErrorIssue>
    ): A {
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
