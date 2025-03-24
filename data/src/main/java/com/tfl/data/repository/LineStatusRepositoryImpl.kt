package com.tfl.data.repository

import com.tfl.data.repository.source.LineStatusDataSource
import com.tfl.domain.model.TubeLineStatus
import com.tfl.domain.repository.LineStatusRepository
import com.tfl.domain.shared.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LineStatusRepositoryImpl @Inject constructor(
    private val lineStatusDataSource: LineStatusDataSource,
) : LineStatusRepository {
    override suspend fun getTubeLineStatus(): Flow<Result<List<TubeLineStatus>>> =
        lineStatusDataSource.getTubeLineStatus()
}