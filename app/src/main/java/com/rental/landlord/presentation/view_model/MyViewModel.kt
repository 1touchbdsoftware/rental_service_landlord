package com.rental.landlord.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rental.landlord.data.model.login.data.LoginData
import com.rental.landlord.presentation.repository.signin.SignIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel constructor(
    private val signIn: SignIn
) : ViewModel() {

    //todo signIn account
    val signInStateFlow = signIn.stateFlow
    fun signInAccount(loginData: LoginData){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                signIn.loginAccount(
                    loginData = loginData
                )
            }
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
    //todo signIn account
}