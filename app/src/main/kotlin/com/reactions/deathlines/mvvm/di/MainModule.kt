package com.reactions.deathlines.mvvm.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.reactions.deathlines.mvvm.di.home.HomeFragmentModule
import com.reactions.deathlines.presentation.ui.MainActivity

@Module(includes = [HomeFragmentModule::class])
abstract class MainModule {

    //@PerActivity
    @ContributesAndroidInjector
    abstract fun get(): MainActivity
}