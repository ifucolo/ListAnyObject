package com.example.myapplication.source.infrastructure.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ifucolo on 29/11/17.
 */
class CategoryPayload {

    @SerializedName("categories")
    var categories: List<CategoryItemPayload> = ArrayList()

    class CategoryItemPayload {
        @SerializedName("id")
        var id: String = ""

        @SerializedName("name")
        var name: String = ""

        @SerializedName("image")
        var image: String = ""

        @SerializedName("type")
        var type: String = ""

        @SerializedName("number_offers")
        var number_offers: String = ""
    }

}