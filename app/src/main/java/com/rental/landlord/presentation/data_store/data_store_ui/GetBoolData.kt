package com.rental.landlord.presentation.data_store.data_store_ui

import com.rental.landlord.presentation.data_store.DataStore

class GetBoolData constructor(
    private val dataStore: DataStore
) {
    operator fun invoke(key : String) = dataStore.getBoolData(key = key)
}