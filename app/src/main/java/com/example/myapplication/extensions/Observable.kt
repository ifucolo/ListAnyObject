package com.example.myapplication.extensions

import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Created by ifucolo on 8/8/17.
 */
inline fun <T : Any> Observable<T>.toCompletable(): Completable = Completable.fromObservable(this)