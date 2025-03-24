package com.tfl.data.mapper

import com.tfl.data.model.ApiTubeLineStatus
import com.tfl.data.model.ApiTubeLineStatusResponse
import com.tfl.domain.model.LineStatus
import com.tfl.domain.model.TubeLineStatus
import javax.inject.Inject

class LineStatusApiToDomainMapper @Inject constructor() :
    DataMapper<ApiTubeLineStatusResponse, List<TubeLineStatus>> {

    override fun map(data: ApiTubeLineStatusResponse): List<TubeLineStatus> {
        val tubeLineStatus = data.map { apiLineStatus ->
            mapInternals(apiLineStatus)
        }
        return tubeLineStatus
    }

    private fun mapInternals(data: ApiTubeLineStatus): TubeLineStatus {
        data.apply {
            return TubeLineStatus(
                id = id,
                name = name,
                lineStatuses = lineStatuses?.map { lineStatus ->
                    LineStatus(
                        id = lineStatus.id,
                        statusSeverityDescription = lineStatus.statusSeverityDescription,
                        reason = lineStatus.reason
                    )
                }
            )
        }
    }
}
