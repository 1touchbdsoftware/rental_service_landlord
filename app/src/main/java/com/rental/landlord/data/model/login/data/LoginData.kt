package com.rental.landlord.data.model.login.data


import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class LoginData(
    val password: String?,
    val username: String?
)