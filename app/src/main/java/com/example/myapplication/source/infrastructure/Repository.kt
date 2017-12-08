package com.example.myapplication.source.infrastructure

import com.example.myapplication.di.ServerApi
import com.example.myapplication.source.domain.Category
import com.example.myapplication.source.domain.DataSource
import com.example.myapplication.source.domain.mapper.CategoryMapper
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ifucolo on 29/11/17.
 */
open class Repository @Inject constructor(val serverApi: ServerApi): DataSource {

    override fun fetchCategories() : Single<ArrayList<Category>> {

        return serverApi
                .getCategories()
                .map { CategoryMapper.map(it)}
    }

}