package com.example.m5l6kt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l6kt.Model.Fashion
import com.example.m5l6kt.R

class FashionAdapter(var context: Context, var items:ArrayList<Fashion>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_fashion,parent,false)
        return FashionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is FashionViewHolder){
            var iv_image = holder.iv_image

            iv_image.setImageResource(item.image)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FashionViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_image:ImageView

        init {
            iv_image = view.findViewById(R.id.iv_image)
        }
    }
}