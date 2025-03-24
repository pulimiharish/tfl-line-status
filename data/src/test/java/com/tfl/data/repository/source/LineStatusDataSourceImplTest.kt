package com.tfl.data.repository.source

import com.tfl.data.api.LineStatusService
import com.tfl.data.emptyResponseBody
import com.tfl.data.mapper.LineStatusApiToDomainMapper
import com.tfl.data.mockApiTubeLineStatusResponse
import com.tfl.data.mockTubeLineStatusList
import com.tfl.data.repository.ApiResponseHandler
import com.tfl.domain.shared.Result
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest

import org.junit.Before
import org.junit.Test
import retrofit2.Response

class LineStatusDataSourceImplTest {

    private lateinit var service: LineStatusService
    private lateinit var lineStatusApiToDomainMapper: LineStatusApiToDomainMapper
    private lateinit var apiResponseHandler: ApiResponseHandler
    private lateinit var dataSource: LineStatusDataSource

    @Before
    fun setUp() {
        service = mockk()
        lineStatusApiToDomainMapper = mockk()
        apiResponseHandler = ApiResponseHandler()
        dataSource = LineStatusDataSourceImpl(service, lineStatusApiToDomainMapper, apiResponseHandler)
    }

    @Test
    fun `test getTubeLineStatus returns success`(): Unit = runTest {
        // Given
        coEvery { service.getTubeLineStatus() } returns Response.success(mockApiTubeLineStatusResponse())
        coEvery { lineStatusApiToDomainMapper.map(any()) } returns mockTubeLineStatusList()

        // When
        val result = dataSource.getTubeLineStatus().first()

        // Then
        assert(result is Result.Success)
    }

    @Test
    fun `test getTubeLineStatus returns Error response`() = runTest {
        // Given
        coEvery { service.getTubeLineStatus() } returns Response.error(400, emptyResponseBody())

        // When
        val result = dataSource.getTubeLineStatus().first()

        // Then
        assert(result is Result.Error)
    }

    @Test
    fun `test getTubeLineStatus returns an exception`() = runTest {
        // Given
        coEvery { service.getTubeLineStatus() } throws RuntimeException("Exception")

        // When
        val result = dataSource.getTubeLineStatus().first()

        // Then
        assert(result is Result.Error)
    }

}