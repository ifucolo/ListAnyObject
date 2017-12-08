package com.example.myapplication.extensions

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.example.myapplication.R

/**
 * Created by iagomendesfucolo on 08/10/17.
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
    fragmentTransaction.func()
    fragmentTransaction.commit()
}
