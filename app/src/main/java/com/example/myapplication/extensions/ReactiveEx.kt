package com.example.myapplication.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by iagomendesfucolo on 18/10/17.
 */
 operator fun CompositeDisposable.plusAssign(subscribe: Disposable?) {}
