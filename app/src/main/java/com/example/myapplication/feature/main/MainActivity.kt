package com.example.myapplication.feature.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.extensions.addFragment
import com.example.myapplication.extensions.popFragment
import com.example.myapplication.extensions.replaceFragment


class MainActivity : AppCompatActivity(), MainListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){}
            //addFragment(HomeFragment.newInstance())
    }


    override fun openFragment(fragment: Fragment, tag: String) {
        replaceFragment(fragment, tag)
    }


    override fun onBackPressed() {
        if (!popFragment())
            super.onBackPressed()
    }
}
