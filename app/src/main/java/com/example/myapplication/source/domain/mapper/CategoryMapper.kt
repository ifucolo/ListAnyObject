package com.example.myapplication.source.domain.mapper

import com.example.myapplication.source.domain.Category
import com.example.myapplication.source.infrastructure.model.CategoryPayload


/**
 * Created by iagomendesfucolo on 18/10/17.
 */
object CategoryMapper {

    fun map(categoryPayload: CategoryPayload) = ArrayList<Category>().apply {

        categoryPayload.categories.let {
            for (category in categoryPayload.categories) {
                add(Category().apply {
                    name = category.name
                    id = category.id
                    image = category.image
                    type = category.type
                    number_offers = category.number_offers
                })
            }
        }
    }

}