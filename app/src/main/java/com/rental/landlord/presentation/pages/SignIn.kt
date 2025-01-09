package com.rental.landlord.presentation.pages

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.onetouch.service.Utils.NetworkResult
import com.rental.landlord.data.model.login.data.LoginData
import com.rental.landlord.databinding.SigninBinding
import com.rental.landlord.presentation.view_model.DataStoreViewModel
import com.rental.landlord.presentation.view_model.MyViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "SignIn"
class SignIn : Fragment() {

    private val binding by lazy {
        SigninBinding.inflate(layoutInflater)
    }
    private val dataStore : DataStoreViewModel by viewModel()
    private val viewModel : MyViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        lifecycleScope.launch { 
            viewModel.signInStateFlow.collectLatest {
                when(it){
                    is NetworkResult.Success -> {
                        Log.d(TAG, "onViewCreated: success ${it.data?.data}")
                    }
                    is NetworkResult.Loading -> {
                        Log.d(TAG, "onViewCreated: loading")
                    }
                    is NetworkResult.Error -> {
                        Log.d(TAG, "onViewCreated: error ${it.message}")
                    }
                    is NetworkResult.Empty -> {

                    }
                }
            }
        }

        viewModel.signInAccount(
            LoginData(
                username = "L0003",
                password = "20691028"
            )
        )
    }

}