package com.onetouch.service.Utils

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentManager
import com.rental.landlord.R
import me.pisal.alerter.Alerter

object AlerterDialog {

    fun success(title : String, message : String, supportFragmentManager: FragmentManager, context : Context, icon : Int){
        Alerter.success()
            .setIconDrawable(
                ResourcesCompat
                    .getDrawable(context.resources, R.drawable.ic_launcher_background, context.theme)
            )
            .withTitle(title)
            .withMessage(message)
            .show(supportFragmentManager, "Tag")
    }

    fun alert_error(title : String, message : String, supportFragmentManager: FragmentManager){
        Alerter.error()
            .withTitle(title)
            .withMessage(message)
            .show(supportFragmentManager, "Tag")
    }

    fun info(title : String, message : String, supportFragmentManager: FragmentManager){
        Alerter.info()
            .withTitle(title)
            .withMessage(message)
            .show(supportFragmentManager, "Tag")
    }
}