package com.rental.landlord.di

import com.rental.landlord.presentation.repository.signin.SignIn
import com.rental.landlord.presentation.view_model.MyViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    factory {
        SignIn(
            httpClient = get()
        )
    }

    viewModel {
        MyViewModel(
            signIn = get()
        )
    }
}