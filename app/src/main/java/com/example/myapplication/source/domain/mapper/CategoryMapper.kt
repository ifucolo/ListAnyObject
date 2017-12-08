package com.example.myapplication.source.domain.mapper

import com.example.myapplication.source.domain.Category
import com.example.myapplication.source.infrastructure.model.CategoryPayload


/**
 * Created by iagomendesfucolo on 18/10/17.
 */
object CategoryMapper {

    fun map(categoryPayload: CategoryPayload) = categoryPayload.categories.mapTo(ArrayList<Any>()) {

        Category().apply {
            name = it.name
            id = it.id
            image = it.image
            type = it.type
            number_offers = it.number_offers
        }
    }
}