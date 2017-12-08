package com.example.myapplication.feature.base.delegate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.feature.base.ListGenericAdapter
import com.example.myapplication.source.domain.Category
import com.example.myapplication.source.infrastructure.model.CategoryPayload
import com.hannesdorfmann.adapterdelegates3.AbsListItemAdapterDelegate

/**
 * Created by ifucolo on 08/12/17.
 */
class HomerDelegate constructor(): AbsListItemAdapterDelegate<Category, Any, HomerDelegate.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.img_home)
        lateinit var photo: ImageView

        @BindView(R.id.txt_name)
        lateinit var name: TextView

        @BindView(R.id.txt_offer)
        lateinit var offer: TextView

        init {
            ButterKnife.bind(this, itemView)
        }
    }

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is Category
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_delegate_home, parent, false))
    }

    override fun onBindViewHolder(category: Category, holder: ViewHolder, payloads: MutableList<Any>) {
        val context = holder.itemView.context

        Glide.with(context)
                .load(category.image)
                .into(holder.photo)

        holder.name.text = category.name
        holder.offer.text = category.number_offers

    }
}