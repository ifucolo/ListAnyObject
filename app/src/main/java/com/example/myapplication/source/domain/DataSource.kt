package com.example.myapplication.source.domain

import io.reactivex.Single

/**
 * Created by ifucolo on 29/11/17.
 */
interface DataSource {

    fun fetchCategories(): Single<ArrayList<Any>>
}