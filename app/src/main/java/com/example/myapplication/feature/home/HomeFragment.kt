package com.example.myapplication.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.ListAnyObjectApplication
import com.example.myapplication.R
import com.example.myapplication.extensions.show
import com.example.myapplication.feature.base.BaseListFragment
import com.example.myapplication.feature.base.ListGenericAdapter
import com.example.myapplication.source.domain.Category
import javax.inject.Inject

/**
 * Created by ifucolo on 08/12/17.
 */
class HomeFragment : BaseListFragment(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter

    companion object {

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        ListAnyObjectApplication().get().getCoreComponent().inject(this)

        presenter.bind(this)
        initView(view)

        return view
    }

    override fun loadData(page: Int) {
        presenter.fetchHome()
    }


    override fun showError(throwable: Throwable) {
        message.show()
    }

    override fun showResult(list: ArrayList<Any>) {
        removeLoader()

        if(list.isEmpty())
            return

        val size = items.size

        items.addAll(list)

        listGenericAdapter?.notifyItemRangeChanged(size, items.size)

        insertLoader()
    }

    override fun onDestroy() {
        presenter.unbind()
        super.onDestroy()
    }
}