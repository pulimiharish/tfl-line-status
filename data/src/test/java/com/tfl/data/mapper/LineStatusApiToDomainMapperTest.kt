package com.tfl.data.mapper

import com.tfl.data.mockApiTubeLineStatusResponse
import com.tfl.data.model.ApiTubeLineStatusResponse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class LineStatusApiToDomainMapperTest {

    private lateinit var mapper: LineStatusApiToDomainMapper
    private lateinit var apiTubeLineStatusResponse: ApiTubeLineStatusResponse

    @Before
    fun setUp() {
        // Given
        mapper = LineStatusApiToDomainMapper()
        apiTubeLineStatusResponse = mockApiTubeLineStatusResponse()
    }

    @Test
    fun `test mapper maps Api object to data object`() {

        // When
        val tubeStatusList = mapper.map(apiTubeLineStatusResponse)

        // Then
        assertEquals(2, tubeStatusList.size)

        val tube1 = tubeStatusList[0]
        assertNotNull(tube1)
        tube1.apply {
            assertEquals("bakerloo", id)
            assertEquals("Bakerloo", name)

            assertEquals(2, lineStatuses?.size)
            assertNotNull(lineStatuses)
            lineStatuses?.let {
                val lineStatus1 = it[0]
                lineStatus1.apply {
                    assertEquals("Minor Delays", statusSeverityDescription)
                    assertEquals(
                        "Bakerloo Line: Minor delays due to an earlier signal failure at Baker Street.",
                        reason
                    )
                }

                val lineStatus2 = it[1]
                lineStatus2.apply {
                    assertEquals("Severe Delays", statusSeverityDescription)
                    assertEquals(
                        "Central Line: Severe delays due to a faulty train at Holborn. Ticket are being accepted on London Buses, Liberty Line, Elizabeth Line, Chiltern Railways, Great Western Railway and Greater Anglia.",
                        reason
                    )
                }
            }
        }

        val tube2 = tubeStatusList[1]
        assertNotNull(tube2)
        tube2.apply {
            assertEquals("central", id)
            assertEquals("Central", name)

            assertEquals(2, lineStatuses?.size)
            assertNotNull(lineStatuses)
            lineStatuses?.let {
                val lineStatus1 = it[0]
                lineStatus1.apply {
                    assertEquals("Minor Delays", statusSeverityDescription)
                    assertEquals(
                        "Bakerloo Line: Minor delays due to an earlier signal failure at Baker Street.",
                        reason
                    )
                }

                val lineStatus2 = it[1]
                lineStatus2.apply {
                    assertEquals("Severe Delays", statusSeverityDescription)
                    assertEquals(
                        "Central Line: Severe delays due to a faulty train at Holborn. Ticket are being accepted on London Buses, Liberty Line, Elizabeth Line, Chiltern Railways, Great Western Railway and Greater Anglia.",
                        reason
                    )
                }
            }
        }
    }

    @Test(timeout = 100)
    fun `test there is no timeout in the mapper method`() {
        mapper.map(apiTubeLineStatusResponse)
    }

    @Test
    fun `test mapper maps multiple objects correctly`() {
        // When
        val tubeLineStatusList = mapper.map(apiTubeLineStatusResponse)

        // Then
        assertEquals(2, tubeLineStatusList.size)
        assertTrue(tubeLineStatusList[0].id == "bakerloo")
        assertTrue(tubeLineStatusList[1].id == "central")
    }
}