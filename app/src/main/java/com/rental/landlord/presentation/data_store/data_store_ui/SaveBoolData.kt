package com.rental.landlord.presentation.data_store.data_store_ui

import com.rental.landlord.presentation.data_store.DataStore

class SaveBoolData constructor(
    private val dataStore: DataStore
) {

    suspend operator fun invoke(key : String, value : Boolean) =
        dataStore.saveBoolData(key = key, value = value)
}