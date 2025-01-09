package com.rental.landlord.data.data_manager

import io.ktor.http.URLProtocol

object DataManager {

    const val DATASTORE = "MyDataStorePref"
    const val BASE_URL = "192.168.0.10:9097"
    val PROTOCOL = URLProtocol.HTTP

    const val ACCESS_TOKEN = "Token"
}