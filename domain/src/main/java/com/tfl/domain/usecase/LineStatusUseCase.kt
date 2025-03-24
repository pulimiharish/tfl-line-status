package com.tfl.domain.usecase

import com.tfl.domain.repository.LineStatusRepository
import javax.inject.Inject

class LineStatusUseCase @Inject constructor(private val lineStatusRepository: LineStatusRepository) {
    suspend operator fun invoke() = lineStatusRepository.getTubeLineStatus()
}