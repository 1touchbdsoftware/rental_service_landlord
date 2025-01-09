package com.rental.landlord.di

import com.rental.landlord.presentation.data_store.DataStoreImp
import com.rental.landlord.presentation.data_store.data_store_ui.ClearDataStore
import com.rental.landlord.presentation.data_store.data_store_ui.GetBoolData
import com.rental.landlord.presentation.data_store.data_store_ui.GetIntData
import com.rental.landlord.presentation.data_store.data_store_ui.GetStringData
import com.rental.landlord.presentation.data_store.data_store_ui.SaveBoolData
import com.rental.landlord.presentation.data_store.data_store_ui.SaveIntData
import com.rental.landlord.presentation.data_store.data_store_ui.SaveStringData
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module
import com.rental.landlord.presentation.data_store.DataStore
import com.rental.landlord.presentation.view_model.DataStoreViewModel
import org.koin.core.module.dsl.viewModel

val dataStoreModule = module {
    single {
        DataStoreImp(context = androidContext())
    }.bind<DataStore>()

    factory {
        SaveStringData(
            dataStore = get()
        )
    }
    factory {
        SaveIntData(
            dataStore = get()
        )
    }
    factory {
        SaveBoolData(
            dataStore = get()
        )
    }

    factory {
        GetStringData(
            dataStore = get()
        )
    }
    factory {
        GetIntData(
            dataStore = get()
        )
    }
    factory {
        GetBoolData(
            dataStore = get()
        )
    }

    factory {
        ClearDataStore(
            dataStore = get()
        )
    }

    factory {
        com.rental.landlord.data.dataStore.DataStore(
            saveStringData = get(),
            saveIntData = get(),
            saveBoolData = get(),
            getStringData = get(),
            getIntData = get(),
            getBoolData = get(),
            clearDataStore = get()
        )
    }

    factory {
        com.rental.landlord.presentation.repository.data_store.DataStore(
            saveStringData = get(),
            saveIntData = get(),
            saveBoolData = get(),
            getStringData = get(),
            getIntData = get(),
            getBoolData = get(),
            clearDataStore = get()
        )
    }

    viewModel {
        DataStoreViewModel(
            dataStore = get()
        )
    }
}