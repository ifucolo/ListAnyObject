package com.example.myapplication.feature.base

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapplication.R
import com.example.myapplication.extensions.hide
import com.example.myapplication.extensions.show
import com.example.myapplication.source.domain.Loader
import com.example.myapplication.widget.EndlessRecyclerViewScrollListener

/**
 * Created by ifucolo on 29/11/17.
 */
abstract class BaseListFragment: BaseFragment() {

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView

    @BindView(R.id.message)
    lateinit var message: TextView

    protected var items: ArrayList<Any> =  ArrayList()
    protected var listGenericAdapter : ListGenericAdapter? = null
    private var endlessRecyclerViewScrollListener: EndlessRecyclerViewScrollListener? = null


    protected fun initView(view: View) {
        ButterKnife.bind(this, view)

        setupRecycler()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listGenericAdapter = ListGenericAdapter(items)

        insertLoader()
    }

    abstract fun loadData(page: Int)

    protected fun setupRecycler() = with(recyclerView) {
        val oldState = endlessRecyclerViewScrollListener?.state

        val linearLayoutManager = LinearLayoutManager(activity)
        endlessRecyclerViewScrollListener = object : EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                loadData(page - 1)
            }
        }

        endlessRecyclerViewScrollListener?.state = oldState
        addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        layoutManager = linearLayoutManager
        adapter = listGenericAdapter

        addOnScrollListener(endlessRecyclerViewScrollListener)
    }

    protected fun hasOnlyLoader(): Boolean {
        if (items.isEmpty())
            return false

        val lastPosition = items.size - 1
        return items[lastPosition] is Loader
    }

    protected fun insertLoader() {
        items.add(Loader())
        listGenericAdapter?.notifyItemInserted(items.size - 1)
    }


    protected fun removeLoader() {
        if (items.isEmpty())
            return

        val lastIndex = items.size - 1
        if (items[lastIndex] is Loader) {
            items.removeAt(lastIndex)

            listGenericAdapter?.notifyItemRemoved(lastIndex)
        }
    }

    protected open fun resetState() {
        items.clear()

        insertLoader()
        listGenericAdapter?.notifyDataSetChanged()

        message.hide()
        recyclerView.show()

        endlessRecyclerViewScrollListener?.resetState()
        endlessRecyclerViewScrollListener?.onScrolled(recyclerView, 0, 0)
    }

}