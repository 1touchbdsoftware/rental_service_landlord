package com.rental.landlord.presentation.repository.data_store

import com.rental.landlord.presentation.data_store.data_store_ui.ClearDataStore
import com.rental.landlord.presentation.data_store.data_store_ui.GetBoolData
import com.rental.landlord.presentation.data_store.data_store_ui.GetIntData
import com.rental.landlord.presentation.data_store.data_store_ui.GetStringData
import com.rental.landlord.presentation.data_store.data_store_ui.SaveBoolData
import com.rental.landlord.presentation.data_store.data_store_ui.SaveIntData
import com.rental.landlord.presentation.data_store.data_store_ui.SaveStringData
import kotlinx.coroutines.flow.Flow

class DataStore constructor(
    private val saveStringData: SaveStringData,
    private val saveIntData: SaveIntData,
    private val saveBoolData: SaveBoolData,

    private val getStringData: GetStringData,
    private val getIntData: GetIntData,
    private val getBoolData: GetBoolData,

    private val clearDataStore: ClearDataStore
) {

    suspend fun saveString(key : String, value : String) = saveStringData(key = key, value = value)
    suspend fun saveInt(key : String, value : Int) = saveIntData(key = key, value = value)
    suspend fun saveBool(key : String, value : Boolean) = saveBoolData(key = key, value = value)


    fun getString(key : String) : Flow<String> = getStringData(key = key)
    fun getInt(key : String) : Flow<Int> = getIntData(key = key)
    fun getBool(key : String) : Flow<Boolean> = getBoolData(key = key)

    suspend fun clearData() = clearDataStore()
}