package com.arcanesecurity.nasalightning.repository

import com.arcanesecurity.nasalightning.model.LightningStrike
import com.arcanesecurity.nasalightning.services.NasaEndpoints
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class NasaRepository @Inject constructor(private val endpoints: NasaEndpoints) {

    suspend fun fetchLights(): List<LightningStrike>? {
        return withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
            val response = endpoints.fetchLights("dublin", "ireland", "08/09/2021")
            processData(response)
        }
    }

    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }

}