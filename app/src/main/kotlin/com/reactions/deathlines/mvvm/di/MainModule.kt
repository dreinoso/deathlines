package com.reactions.deathlines.mvvm.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.reactions.deathlines.mvvm.di.home.HomeFragmentModule
import com.reactions.deathlines.presentation.ui.features.goals.AddGoalsActivity
import com.reactions.deathlines.presentation.ui.features.main.MainActivity

@Module(includes = [HomeFragmentModule::class])
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun get(): MainActivity

    @ContributesAndroidInjector
    abstract fun addGoalActivity(): AddGoalsActivity
}