package com.rental.landlord.presentation.data_store.data_store_ui

import com.rental.landlord.presentation.data_store.DataStore
import kotlinx.coroutines.flow.Flow

class GetIntData constructor(
    private val dataStore: DataStore
) {
    operator fun invoke(key : String) : Flow<Int> = dataStore.getIntData(key = key)
}