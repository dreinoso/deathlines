package com.reactions.deathlines.presentation.ui.features.goals

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.reactions.deathlines.presentation.R
import com.reactions.deathlines.presentation.ui.base.BaseActivity
import com.reactions.deathlines.presentation.ui.features.home.HomeFragment
import com.reactions.deathlines.presentation.ui.features.tasks.TasksFragment
import com.reactions.deathlines.presentation.ui.features.upcoming.UpcomingFragment
import kotlinx.android.synthetic.main.activity_main.*

class AddGoalsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_goal)
    }

    override fun getNavControllerId(): Int = R.id.addGoalsActivity
}