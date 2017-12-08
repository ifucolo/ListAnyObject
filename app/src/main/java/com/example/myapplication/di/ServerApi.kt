package com.example.myapplication.di

import com.example.myapplication.source.infrastructure.model.CategoryPayload
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by ifucolo on 29/11/17.
 */
interface ServerApi {

    @GET("categories")
    fun getCategories(): Single<CategoryPayload>
}