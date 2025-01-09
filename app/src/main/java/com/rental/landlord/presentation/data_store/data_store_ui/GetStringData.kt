package com.rental.landlord.presentation.data_store.data_store_ui

import com.rental.landlord.presentation.data_store.DataStore
import kotlinx.coroutines.flow.Flow

class GetStringData constructor(
    private val dataStore: DataStore
) {
    operator fun invoke(key : String) : Flow<String> = dataStore.getStringData(key = key)
}