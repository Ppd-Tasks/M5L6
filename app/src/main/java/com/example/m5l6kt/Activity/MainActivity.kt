package com.example.m5l6kt.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l6kt.Adapter.*
import com.example.m5l6kt.Model.*
import com.example.m5l6kt.R

class MainActivity : AppCompatActivity() {
    lateinit var rv_essential:RecyclerView
    lateinit var rv_fashion:RecyclerView
    lateinit var rv_popular:RecyclerView
    lateinit var rv_topSellers:RecyclerView
    lateinit var rv_explore:RecyclerView

    lateinit var ll_fashion:LinearLayout
    lateinit var ll_popular:LinearLayout
    lateinit var ll_topSellers:LinearLayout
    lateinit var ll_explore:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }
    fun initViews(){
        ll_fashion = findViewById(R.id.ll_fashion)
        ll_popular = findViewById(R.id.ll_pupular)
        ll_topSellers = findViewById(R.id.ll_topSellers)
        ll_explore = findViewById(R.id.ll_explore)

        rv_essential = findViewById(R.id.rv_essential)
        rv_fashion = findViewById(R.id.rv_fashion)
        rv_popular = findViewById(R.id.rv_popular)
        rv_topSellers = findViewById(R.id.rv_topSellers)
        rv_explore = findViewById(R.id.rv_explore)

        val manager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_essential.setLayoutManager(manager)

        rv_fashion.setLayoutManager(GridLayoutManager(this,2))

        rv_popular.setLayoutManager(GridLayoutManager(this,2))

        rv_topSellers.setLayoutManager(GridLayoutManager(this,1))

        rv_explore.setLayoutManager(GridLayoutManager(this,2))

        refreshAdapter(getAllItems())
        refreshAdapterFashion(getAllItemsFashion())
        refreshAdapterPopular(getAllItemsPopular())
        refreshAdapterTopSellers(getAllItemsTopSellers())
        refreshAdapterExplore(getAllItemsExplore())

        setLinearHeight(ll_fashion)
        setLinearHeight(ll_popular)
        setLinearHeight(ll_topSellers)
        setLinearHeight(ll_explore)
    }

    fun setLinearHeight(layout: LinearLayout){
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        var heightPixels = displayMetrics.heightPixels

        val  heightInDp:Int = heightPixels/resources.displayMetrics.density.toInt()

        val params:ViewGroup.LayoutParams = layout.layoutParams
        params.height = heightInDp
        layout.layoutParams = params
    }

    fun refreshAdapter(items:ArrayList<Essential>){
        val adapter = EssentialAdapter(this,items)
        rv_essential.adapter = adapter
    }
    fun refreshAdapterFashion(items:ArrayList<Fashion>){
        val adapter = FashionAdapter(this,items)
        rv_fashion.adapter = adapter
    }
    fun refreshAdapterPopular(items:ArrayList<Popular>){
        val adapter = PopularAdapter(this,items)
        rv_popular.adapter = adapter
    }
    fun refreshAdapterTopSellers(items:ArrayList<TopSellers>){
        val adapter = TopSellersAdapter(this,items)
        rv_topSellers.adapter = adapter
    }
    fun refreshAdapterExplore(items:ArrayList<Explore>){
        val adapter = ExploreAdapter(this,items)
        rv_explore.adapter = adapter
    }

    fun getAllItems():ArrayList<Essential>{
        val items:ArrayList<Essential> = ArrayList()

        items.add(Essential("Oculus",R.drawable.img_9))
        items.add(Essential("Gamer",R.drawable.img_10))
        items.add(Essential("Mobile",R.drawable.img_11))

        return items
    }
    fun getAllItemsFashion():ArrayList<Fashion>{
        val items:ArrayList<Fashion> = ArrayList()

        items.add(Fashion(R.drawable.img_1))
        items.add(Fashion(R.drawable.img_2))
        items.add(Fashion(R.drawable.img_3))
        items.add(Fashion(R.drawable.img_4))

        return items
    }
    fun getAllItemsPopular():ArrayList<Popular>{
        val items:ArrayList<Popular> = ArrayList()

        items.add(Popular(R.drawable.img_5))
        items.add(Popular(R.drawable.img_6))
        items.add(Popular(R.drawable.img_7))
        items.add(Popular(R.drawable.img_8))

        return items
    }
    fun getAllItemsTopSellers():ArrayList<TopSellers>{
        val items:ArrayList<TopSellers> = ArrayList()

        items.add(TopSellers(R.drawable.img_12,"The Very Hungry Caterpillar","$5⁰⁶",""))
        items.add(TopSellers(R.drawable.img_13,"If Animals Kissed Good Night","$3⁵⁵",getString(R.string.price1)))
        items.add(TopSellers(R.drawable.img_14,"Chicka Chicka Boom Boom (Board Book)","$4⁵⁹",getString(R.string.price1)))

        return items
    }
    fun getAllItemsExplore():ArrayList<Explore>{
        val items:ArrayList<Explore> = ArrayList()

        items.add(Explore("Beauty",R.drawable.img_15))
        items.add(Explore("Home and Kitchen",R.drawable.img_16))
        items.add(Explore("Sports and Outdoors",R.drawable.img_17))
        items.add(Explore("Electronics",R.drawable.img_18))
        items.add(Explore("Outdoor Clothing",R.drawable.img_19))
        items.add(Explore("Pet Supplies",R.drawable.img_20))

        return items
    }
}