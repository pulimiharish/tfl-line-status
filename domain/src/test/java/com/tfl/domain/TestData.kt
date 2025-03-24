package com.tfl.domain

import com.tfl.domain.model.LineStatus
import com.tfl.domain.model.TubeLineStatus

fun mockTubeLineStatusList(): List<TubeLineStatus> {
    return listOf(
        mockTube1(),
        mockTube2()
    )
}

fun mockTube1(): TubeLineStatus {
    return TubeLineStatus(
        id = "bakerloo",
        name = "Bakerloo",
        lineStatuses = listOf(
            mockLineStatus1(),
            mockLineStatus2()
        )
    )
}

fun mockTube2(): TubeLineStatus {
    return TubeLineStatus(
        id = "central",
        name = "Central",
        lineStatuses = listOf(
            mockLineStatus1(),
            mockLineStatus2()
        )
    )
}

fun mockLineStatus1(): LineStatus {
    return LineStatus(
        id = 0,
        statusSeverityDescription = "Minor Delays",
        reason = "Bakerloo Line: Minor delays due to an earlier signal failure at Baker Street."
    )
}

fun mockLineStatus2(): LineStatus {
    return LineStatus(
        id = 0,
        statusSeverityDescription = "Severe Delays",
        reason = "Central Line: Severe delays due to a faulty train at Holborn. Ticket are being accepted on London Buses, Liberty Line, Elizabeth Line, Chiltern Railways, Great Western Railway and Greater Anglia."
    )
}