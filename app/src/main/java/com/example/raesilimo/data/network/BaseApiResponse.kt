package com.example.raesilimo.data.network

import com.example.raesilimo.data.database.RealmDao
import retrofit2.Response

/**This class get a suspend lambda method with generic type of retrofit response
 * and check it's successfully state and returned an generic instance of NetworkResult class
 * corresponding it's successfully state
 *
 * param:
 *          apiCall: a suspend lambda function with generic type of Response
 * return:
 *          an generic instance of NetworkResult class */

class BaseApiResponse {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
        try {
            val response = apiCall.invoke()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return NetworkResult.Success(body)
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(errorMessage: String): NetworkResult<T> =
        NetworkResult.Error("Api call failed $errorMessage")
}