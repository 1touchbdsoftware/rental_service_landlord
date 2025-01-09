package com.rental.landlord.presentation.data_store

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.rental.landlord.data.data_manager.DataManager.DATASTORE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreImp constructor(val context: Context) : DataStore {

    private val Context.datastore: androidx.datastore.core.DataStore<Preferences> by preferencesDataStore(
        name = DATASTORE
    )

    override suspend fun saveStringData(key: String, value: String) {
        context.datastore.edit { dataStore ->
            dataStore[stringPreferencesKey(name = key)] = value
        }
    }

    override suspend fun saveIntData(key: String, value: Int) {
        context.datastore.edit { dataStore ->
            dataStore[intPreferencesKey(name = key)] = value
        }
    }

    override suspend fun saveBoolData(key: String, value: Boolean) {
        context.datastore.edit { dataStore ->
            dataStore[booleanPreferencesKey(name = key)] = value
        }
    }

    override fun getStringData(key: String): Flow<String> {
        return context.datastore.data.map { dataStore ->
            dataStore[stringPreferencesKey(name = key)] ?: ""
        }
    }

    override fun getIntData(key: String): Flow<Int> {
        return context.datastore.data.map { dataStore ->
            dataStore[intPreferencesKey(name = key)] ?: 0
        }
    }

    override fun getBoolData(key: String): Flow<Boolean> {
        return context.datastore.data.map { dataStore ->
            dataStore[booleanPreferencesKey(name = key)] ?: false
        }
    }

    override suspend fun clearDataStore() {
        context.datastore.edit { dataStore ->
            dataStore.clear()
        }
    }
}