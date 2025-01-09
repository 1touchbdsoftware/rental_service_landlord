package com.rental.landlord.data.model.login.response


import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class LoginResponse(
    val `data`: Data?,
    val message: String?,
    val statusCode: Int?
)