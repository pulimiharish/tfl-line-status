package com.tfl.data

import com.tfl.data.model.ApiLineStatus
import com.tfl.data.model.ApiTubeLineStatus
import com.tfl.data.model.ApiTubeLineStatusResponse
import okhttp3.ResponseBody.Companion.toResponseBody

internal fun mockApiTubeLineStatusResponse(): ApiTubeLineStatusResponse {
    return listOf(
        mockApiTube1(),
        mockApiTube2()
    )
}

fun mockApiTube1(): ApiTubeLineStatus {
    return ApiTubeLineStatus(
        id = "bakerloo",
        name = "Bakerloo",
        lineStatuses = listOf(
            mockApiLineStatus1(),
            mockApiLineStatus2()
        )
    )
}

fun mockApiTube2(): ApiTubeLineStatus {
    return ApiTubeLineStatus(
        id = "central",
        name = "Central",
        lineStatuses = listOf(
            mockApiLineStatus1(),
            mockApiLineStatus2()
        )
    )
}

fun mockApiLineStatus1(): ApiLineStatus {
    return ApiLineStatus(
        id = 0,
        statusSeverityDescription = "Minor Delays",
        reason = "Bakerloo Line: Minor delays due to an earlier signal failure at Baker Street."
    )
}

fun mockApiLineStatus2(): ApiLineStatus {
    return ApiLineStatus(
        id = 0,
        statusSeverityDescription = "Severe Delays",
        reason = "Central Line: Severe delays due to a faulty train at Holborn. Ticket are being accepted on London Buses, Liberty Line, Elizabeth Line, Chiltern Railways, Great Western Railway and Greater Anglia."
    )
}

internal fun emptyResponseBody() = "".toResponseBody(null)