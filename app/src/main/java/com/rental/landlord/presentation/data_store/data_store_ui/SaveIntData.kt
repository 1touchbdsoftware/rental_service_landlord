package com.rental.landlord.presentation.data_store.data_store_ui

import com.rental.landlord.presentation.data_store.DataStore

class SaveIntData constructor(
    private val dataStore: DataStore
) {

    suspend operator fun invoke(key: String, value: Int) =
        dataStore.saveIntData(key = key, value = value)
}