package com.tfl.domain.repository

import com.tfl.domain.model.TubeLineStatus
import com.tfl.domain.shared.Result
import kotlinx.coroutines.flow.Flow

interface LineStatusRepository {
    suspend fun getTubeLineStatus(): Flow<Result<List<TubeLineStatus>>>
}