package com.example.myapplication.feature.main

import android.support.v4.app.Fragment

/**
 * Created by ifucolo on 29/11/17.
 */
interface MainListener {

    fun openFragment(fragment: Fragment, tag: String)
}