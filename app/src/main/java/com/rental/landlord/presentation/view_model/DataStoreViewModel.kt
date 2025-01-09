package com.rental.landlord.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rental.landlord.presentation.repository.data_store.DataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DataStoreViewModel constructor(
    private val dataStore: DataStore
) : ViewModel() {

    fun saveStringData(key : String, value : String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                dataStore.saveString(key = key, value = value)
            }
        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    fun saveIntData(key : String, value : Int){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                dataStore.saveInt(key = key, value = value)
            }
        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    fun saveBoolData(key : String, value : Boolean){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                dataStore.saveBool(key = key, value = value)
            }
        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    fun getStringData(key : String) : Flow<String> = dataStore.getString(key = key)
    fun getIntData(key : String) : Flow<Int> = dataStore.getInt(key = key)
    fun getBoolData(key : String) : Flow<Boolean> = dataStore.getBool(key = key)
}