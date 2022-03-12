package com.example.raesilimo.data.network

/**This class is based on the success status of the server response that specified
 * in BaseApiResponse class, return one of following Class instance for handling
 * retrofit response state
 *
 * param:
 *        data: generic type of data that received from server
 *        message: a string message from unsuccess server response
 */
sealed class NetworkResult<T> (val data : T? = null, val message : String? = null){

    class Success<T> (data: T) : NetworkResult<T>(data)

    class Error<T> (message : String, data: T? = null) : NetworkResult<T>(data, message)

    class Loading<T> : NetworkResult<T>()
}
