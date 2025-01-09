package com.rental.landlord.presentation.data_store.data_store_ui

import com.rental.landlord.presentation.data_store.DataStore

class ClearDataStore constructor(
    private val dataStore: DataStore
){
    suspend operator fun invoke() = dataStore.clearDataStore()
}