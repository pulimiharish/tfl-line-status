package com.tfl.data.model

data class ApiTubeLineStatus(
    val id: String? = null,
    val name: String? = null,
    val lineStatuses: List<ApiLineStatus>? = null,
)