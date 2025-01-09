package com.rental.landlord.data.model.login.response


import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class UserInfo(
    val agencyID: String?,
    val id: String?,
    val isActive: Boolean?,
    val landlordID: String?,
    val landlordName: String?,
    val userName: String?
)