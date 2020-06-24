package com.reactions.deathlines.mvvm.di.home

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.reactions.deathlines.presentation.ui.features.home.HomeFragment

@Module
abstract class HomeFragmentModule {

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment
}