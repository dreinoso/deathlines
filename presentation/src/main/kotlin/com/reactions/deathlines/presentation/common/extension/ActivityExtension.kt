package com.reactions.deathlines.presentation.common.extension

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replaceFragment(savedInstanceState: Bundle?, @IdRes where: Int,
                                      fragment: Fragment, tag: String) {
    if (savedInstanceState == null)
        supportFragmentManager.beginTransaction()
                .replace(where, fragment, tag)
                .commit()
}