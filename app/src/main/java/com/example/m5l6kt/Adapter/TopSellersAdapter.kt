package com.example.m5l6kt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l6kt.Model.Fashion
import com.example.m5l6kt.Model.Popular
import com.example.m5l6kt.Model.TopSellers
import com.example.m5l6kt.R

class TopSellersAdapter(var context: Context, var items:ArrayList<TopSellers>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_top_sellers,parent,false)
        return TopSellersViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is TopSellersViewHolder){
            val iv_image = holder.iv_image
            val tv_title = holder.tv_title
            val tv_price = holder.tv_price
            val tv_price_two = holder.tv_price_two

            iv_image.setImageResource(item.image)
            tv_title.text = item.title
            tv_price.text = item.price
            tv_price_two.text = item.price_two.toString()

            if (tv_price.text == "\$5⁰⁶"){
                tv_price_two.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class TopSellersViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_image:ImageView
        var tv_title:TextView
        var tv_price:TextView
        var tv_price_two:TextView

        init {
            iv_image = view.findViewById(R.id.iv_image)
            tv_title = view.findViewById(R.id.tv_title)
            tv_price = view.findViewById(R.id.tv_price)
            tv_price_two = view.findViewById(R.id.tv_price_two)
        }
    }
}