package com.tfl.domain.usecase

import com.tfl.domain.mockTubeLineStatusList
import com.tfl.domain.model.TubeLineStatus
import com.tfl.domain.repository.LineStatusRepository
import com.tfl.domain.shared.Result
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LineStatusUseCaseTest {

    private val lineStatusRepository = mockk<LineStatusRepository>()
    private lateinit var lineStatusUseCase: LineStatusUseCase

    @Before
    fun setUp() {
        lineStatusUseCase = LineStatusUseCase(lineStatusRepository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `test usecase invoke with Success Response`() = runTest {
        // Given
        val expectedResult = Result.Success(mockTubeLineStatusList())
        coEvery { lineStatusRepository.getTubeLineStatus() } returns flowOf(expectedResult)

        // When
        val result = mutableListOf<Result<List<TubeLineStatus>>>()
        lineStatusUseCase().collect {
            result.add(it)
        }

        // Then
        assertEquals(listOf(expectedResult), result)
    }

    @Test
    fun `test usecase invoke with Error Response`() = runTest {

        // Given
        val expectedResult = Result.Error(IllegalArgumentException("response failed"))
        coEvery { lineStatusRepository.getTubeLineStatus() } returns flowOf(expectedResult)

        // When
        val result = mutableListOf<Result<List<TubeLineStatus>>>()
        lineStatusUseCase().collect {
            result.add(it)
        }

        // Then
        assertEquals(listOf(expectedResult), result)
    }

}