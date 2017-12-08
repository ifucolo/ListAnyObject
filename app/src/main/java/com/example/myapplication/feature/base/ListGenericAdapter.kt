package com.example.myapplication.feature.base

import com.example.myapplication.feature.base.delegate.LoaderDelegate
import com.example.myapplication.source.domain.Category
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter

/**
 * Created by ifucolo on 29/11/17.
 */
class ListGenericAdapter constructor(list: List<Any>, listGenericListener: ListGenericListener) : ListDelegationAdapter<List<Any>>() {

    interface ListGenericListener {

        fun onCLickItemFixed(category: Category)
    }

    init {
        delegatesManager
                .addDelegate(LoaderDelegate())


        setItems(list)
    }
}