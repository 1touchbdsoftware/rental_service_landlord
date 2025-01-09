package com.rental.landlord.data.dataStore

import com.rental.landlord.presentation.data_store.data_store_ui.ClearDataStore
import com.rental.landlord.presentation.data_store.data_store_ui.GetBoolData
import com.rental.landlord.presentation.data_store.data_store_ui.GetIntData
import com.rental.landlord.presentation.data_store.data_store_ui.GetStringData
import com.rental.landlord.presentation.data_store.data_store_ui.SaveBoolData
import com.rental.landlord.presentation.data_store.data_store_ui.SaveIntData
import com.rental.landlord.presentation.data_store.data_store_ui.SaveStringData

data class DataStore(
    private val saveStringData: SaveStringData,
    private val saveIntData: SaveIntData,
    private val saveBoolData: SaveBoolData,

    private val getStringData: GetStringData,
    private val getIntData: GetIntData,
    private val getBoolData: GetBoolData,

    private val clearDataStore: ClearDataStore
)
