package com.example.myapplication.feature.base

import com.example.myapplication.feature.base.delegate.HomerDelegate
import com.example.myapplication.feature.base.delegate.LoaderDelegate
import com.example.myapplication.source.domain.Category
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter

/**
 * Created by ifucolo on 29/11/17.
 */
class ListGenericAdapter constructor(list: List<Any>) : ListDelegationAdapter<List<Any>>() {


    init {
        delegatesManager
                .addDelegate(LoaderDelegate())
                .addDelegate(HomerDelegate())

        setItems(list)
    }
}