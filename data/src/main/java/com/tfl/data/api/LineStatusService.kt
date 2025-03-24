package com.tfl.data.api

import com.tfl.data.model.ApiTubeLineStatusResponse
import retrofit2.Response
import retrofit2.http.GET

interface LineStatusService {

    @GET("Line/Mode/Tube/Status")
    suspend fun getTubeLineStatus(
    ): Response<ApiTubeLineStatusResponse>
}