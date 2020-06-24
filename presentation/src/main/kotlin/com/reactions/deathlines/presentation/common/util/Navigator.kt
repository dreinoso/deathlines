package com.reactions.deathlines.presentation.common.util

import android.app.Activity
import android.content.Context
import android.content.Intent

class Navigator {
    fun navigateToActivity(context: Context, source: Activity, dest: Activity) {
        context.startActivity(Intent(source, dest::class.java))
    }
}