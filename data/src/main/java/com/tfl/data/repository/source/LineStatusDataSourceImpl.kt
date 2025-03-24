package com.tfl.data.repository.source

import com.tfl.data.api.LineStatusService
import com.tfl.data.mapper.LineStatusApiToDomainMapper
import com.tfl.data.repository.ApiResponseHandler
import com.tfl.domain.model.TubeLineStatus
import com.tfl.domain.shared.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LineStatusDataSourceImpl @Inject constructor(
    private val service: LineStatusService,
    private val lineStatusApiToDomainMapper: LineStatusApiToDomainMapper,
    private val apiResponseHandler: ApiResponseHandler
) : LineStatusDataSource {
    override suspend fun getTubeLineStatus(): Flow<Result<List<TubeLineStatus>>> {
        return flow {
            try {
                val response = service.getTubeLineStatus()
                apiResponseHandler.handleApiResponse(response,
                    onSuccess = {
                        emit(Result.Success(lineStatusApiToDomainMapper.map(it)))
                    }, onError = {
                        emit(Result.Error(IllegalArgumentException("response failed")))
                    }
                )
            } catch (e: Exception) {
                emit(Result.Error(e))
            }
        }.flowOn(Dispatchers.IO)
    }
}