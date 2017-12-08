package com.example.myapplication.util.rx

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by ifucolo on 29/11/17.
 */

open class ReactivePresenter<V> {
    val disposables = CompositeDisposable()
    var view: V? = null
        private set

    fun disposables() = disposables
    fun view() = view

    open fun bind(view: V) {
        this.view = view
    }

    fun unbind() {
        this.disposables.clear()
        this.view = null
    }

    protected val isBinded: Boolean
        get() = this.view != null
}