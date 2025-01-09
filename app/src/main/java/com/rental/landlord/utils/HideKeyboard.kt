package com.onetouch.service.Utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object HideKeyboard {
    fun hideKeyboard(context: Context, currentFocus : View) {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        currentFocus.let { view ->
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}