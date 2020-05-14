package com.reactions.deathlines.presentation.ui

import android.os.Bundle
import com.reactions.deathlines.presentation.R
import com.reactions.deathlines.presentation.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getNavControllerId(): Int = R.id.activityMainHomeHostFragment
}