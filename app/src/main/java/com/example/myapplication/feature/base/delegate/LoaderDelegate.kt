package com.example.myapplication.feature.base.delegate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.source.domain.Loader
import com.example.myapplication.R
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate

/**
 * Created by ifucolo on 29/11/17.
 */
class LoaderDelegate : AbsListItemAdapterDelegate<Loader, Any, LoaderDelegate.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun isForViewType(item: Any,items: List<Any>, position: Int): Boolean {
        return item is Loader
    }

    override fun onCreateViewHolder( parent: ViewGroup): LoaderDelegate.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_delegate_loader, parent, false))
    }

    override fun onBindViewHolder( loader: Loader,  viewHolder: LoaderDelegate.ViewHolder, payloads: List<Any>) {

    }
}
