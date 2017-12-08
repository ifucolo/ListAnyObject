package com.example.myapplication.feature.home

/**
 * Created by ifucolo on 08/12/17.
 */
interface HomeView {

    fun showError(throwable: Throwable)
    fun showResult(list: ArrayList<Any>)
}