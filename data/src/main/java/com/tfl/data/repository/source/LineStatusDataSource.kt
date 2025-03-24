package com.tfl.data.repository.source

import com.tfl.domain.model.TubeLineStatus
import com.tfl.domain.shared.Result
import kotlinx.coroutines.flow.Flow

interface LineStatusDataSource {
    suspend fun getTubeLineStatus(): Flow<Result<List<TubeLineStatus>>>
}