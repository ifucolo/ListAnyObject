package com.example.myapplication.extensions

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.myapplication.R


/**
 * Created by iagomendesfucolo on 08/10/17.    kmsaodmo            jndasjndjndasjndajnd
 */
fun AppCompatActivity.addFragment(fragment: Fragment){
    supportFragmentManager.inTransaction { add(R.id.container, fragment) }
}


fun AppCompatActivity.replaceFragment(fragment: Fragment, tag: String) {
    supportFragmentManager.inTransaction{

        if (findFragmentByTag(tag) != fragment)
            addToBackStack(tag)

        replace(R.id.container, fragment)
    }
}

fun AppCompatActivity.popFragment(): Boolean {
     val fragmentManager = fragmentManager
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStackImmediate()
            return true
        }

    return false
}
/**
 * Method to replace the fragment. The [fragment] is added to the container view with id
 * [containerViewId] and a [tag]. The operation is performed by the supportFragmentManager.
 */
fun AppCompatActivity.replaceFragmentSafely(fragment: Fragment,
                                            tag: String,
                                            allowStateLoss: Boolean = false,
                                            @IdRes containerViewId: Int) {
    val ft = supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(containerViewId, fragment, tag)
    if (!supportFragmentManager.isStateSaved) {
        ft.commit()
    } else if (allowStateLoss) {
        ft.commitAllowingStateLoss()
    }
}

/**
 * Method to add the fragment. The [fragment] is added to the container view with id
 * [containerViewId] and a [tag]. The operation is performed by the supportFragmentManager.
 * This method checks if fragment exists.
 * @return the fragment added.
 */
fun <T : Fragment> AppCompatActivity.addFragmentSafelfy(fragment: T,
                                                        tag: String,
                                                        allowStateLoss: Boolean = false,
                                                        @IdRes containerViewId: Int): T {
    if (!existsFragmentByTag(tag)) {
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
        ft.add(containerViewId, fragment, tag)
        if (!supportFragmentManager.isStateSaved) {
            ft.commit()
        } else if (allowStateLoss) {
            ft.commitAllowingStateLoss()
        }
        return fragment
    }
    return findFragmentByTag(tag) as T
}

/**
 * Method to check if fragment exists. The operation is performed by the supportFragmentManager.
 */
fun AppCompatActivity.existsFragmentByTag(tag: String): Boolean {
    return supportFragmentManager.findFragmentByTag(tag) != null
}

/**
 * Method to get fragment by tag. The operation is performed by the supportFragmentManager.
 */
fun AppCompatActivity.findFragmentByTag(tag: String): Fragment? {
    return supportFragmentManager.findFragmentByTag(tag)
}