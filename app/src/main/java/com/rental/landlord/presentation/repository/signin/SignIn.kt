package com.rental.landlord.presentation.repository.signin

import android.util.Log
import com.onetouch.service.Utils.NetworkResult
import com.rental.landlord.data.data_manager.DataManager
import com.rental.landlord.data.data_manager.DataManager.PROTOCOL
import com.rental.landlord.data.model.login.data.LoginData
import com.rental.landlord.data.model.login.response.LoginResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.buildUrl
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.http.path
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

private const val TAG = "SignIn"
class SignIn constructor(
    private val httpClient: HttpClient
) {

    private val mutableStatFlow = MutableStateFlow<NetworkResult<LoginResponse>>(NetworkResult.Empty())
    val stateFlow = mutableStatFlow.asStateFlow()

    suspend fun loginAccount(loginData: LoginData){
        try {
            mutableStatFlow.emit(NetworkResult.Loading())
            val response = httpClient.post(
                buildUrl {
                    host = DataManager.BASE_URL
                    path("api/LandlordAccess/Login")
                    protocol = PROTOCOL

                }
            ){
                contentType(ContentType.Application.Json)
                setBody(loginData)
            }
            Log.d(TAG, "loginAccount: code ${response.status.value}")
            if(response.status.isSuccess()){
                val body : LoginResponse = response.body()
                mutableStatFlow.emit(NetworkResult.Success(data = body))
            }else {
                mutableStatFlow.emit(NetworkResult.Error(message = "unsuccess"))
            }

        }catch (e : Exception){
            mutableStatFlow.emit(NetworkResult.Error(message = e.message?: ""))
            Log.d(TAG, "loginAccount: error ${e.message}")
        }
    }
}