package com.tfl.linestatus.statuslist.viewmodel

import com.tfl.domain.shared.Result
import com.tfl.domain.usecase.LineStatusUseCase
import com.tfl.linestatus.mockTubeLineStatusList
import com.tfl.linestatus.state.ViewState
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LineStatusViewModelTest {

    private val lineStatusUseCase: LineStatusUseCase = mockk()
    private lateinit var testDispatcher: TestDispatcher

    @Before
    fun setUp() {
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }


    @Test
    fun `test get line status list method failure`() = runTest {
        // Given
        val expectedError = Result.Error(IllegalArgumentException("some error"))
        coEvery { lineStatusUseCase() } returns flowOf(expectedError)

        // When
        val viewModel = LineStatusViewModel(lineStatusUseCase)
        viewModel.getTubeLineStatusList()

        // Then
        val result = viewModel.lineStatusStateFlow.value
        assert(result is ViewState.Error)
        assertEquals(expectedError.throwable.message, (result as ViewState.Error).message)
        assert(result.message == "some error")
    }

    @Test
    fun `test get line status list method success`() = runTest {
        // Given
        val mockLineStatusList = mockTubeLineStatusList()
        val expectedResult = Result.Success(mockLineStatusList)
        coEvery { lineStatusUseCase() } returns flowOf(expectedResult)

        // When
        val viewModel = LineStatusViewModel(lineStatusUseCase)
        advanceUntilIdle()

        // Then
        val state = viewModel.lineStatusStateFlow.value
        assert(state is ViewState.Success) { "Expected ViewState.Success but got ${state::class.simpleName}" }
        assertEquals(expectedResult.data, (state as ViewState.Success).data)
        assert(state.data.size == mockLineStatusList.size) { "Expected size ${mockLineStatusList.size} but got ${state.data.size}" }
    }
}