package com.rental.landlord.presentation.data_store.data_store_ui

import com.rental.landlord.presentation.data_store.DataStore

class SaveStringData constructor(
    private val dataStore: DataStore
) {

    suspend operator fun invoke(key: String, value: String) =
        dataStore.saveStringData(key = key, value = value)
}