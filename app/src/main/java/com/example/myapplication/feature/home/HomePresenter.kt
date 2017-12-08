package com.example.myapplication.feature.home

import com.example.myapplication.source.domain.DataSource
import com.example.myapplication.util.rx.ReactivePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
/**
 * Created by ifucolo on 08/12/17.
 */
class HomePresenter @Inject constructor(val dataSource: DataSource): ReactivePresenter<HomeView>() {


    fun fetchHome() {
        disposables += dataSource.fetchCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {view?.showResult(it)},
                        {view?.showError(it)}
                )
    }
}