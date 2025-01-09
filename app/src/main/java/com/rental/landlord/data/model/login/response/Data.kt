package com.rental.landlord.data.model.login.response


import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class Data(
    val token: String?,
    val userInfo: UserInfo?
)