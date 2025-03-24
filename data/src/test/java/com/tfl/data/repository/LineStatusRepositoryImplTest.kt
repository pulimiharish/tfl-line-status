package com.tfl.data.repository

import com.tfl.data.mockTubeLineStatusList
import com.tfl.data.repository.source.LineStatusDataSource
import com.tfl.domain.repository.LineStatusRepository
import com.tfl.domain.shared.Result
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LineStatusRepositoryImplTest {

    private lateinit var lineStatusDataSource: LineStatusDataSource
    private lateinit var lineStatusRepository: LineStatusRepository

    @Before
    fun setup() {
        lineStatusDataSource = mockk()
        lineStatusRepository = LineStatusRepositoryImpl(lineStatusDataSource)
    }

    @Test
    fun `getTubeLineStatus method returns success`() = runTest {
        // Given
        val expectedResult = Result.Success(mockTubeLineStatusList())
        coEvery { lineStatusDataSource.getTubeLineStatus() } returns flowOf(expectedResult)

        // When
        val result = lineStatusRepository.getTubeLineStatus().toList()

        // Then
        coVerify { lineStatusDataSource.getTubeLineStatus() }
        assertEquals(1, result.size)
        assertEquals(expectedResult, result.first())
    }

    @Test
    fun `getTubeLineStatus method returns error response`() = runTest {
        // Given
        val expectedResult = Result.Error(IllegalArgumentException("response failed"))
        coEvery { lineStatusDataSource.getTubeLineStatus() } returns flowOf(expectedResult)

        // When
        val result = lineStatusRepository.getTubeLineStatus().toList()

        // Then
        coVerify { lineStatusDataSource.getTubeLineStatus() }
        assertEquals(1, result.size)
        assertEquals(expectedResult, result.first())
    }
}