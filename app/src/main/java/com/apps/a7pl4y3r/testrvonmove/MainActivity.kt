package com.apps.a7pl4y3r.testrvonmove

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()
        
    }
    
    
    private fun setRecyclerView() {

        val myList = simpleList()
        val adapter = ItemAdapter(myList)
        
        
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        
        
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {

            override fun onMove(recyclerView: RecyclerView, first: RecyclerView.ViewHolder, second: RecyclerView.ViewHolder): Boolean {


                val initPos = first.adapterPosition
                val finalPos = second.adapterPosition


                Collections.swap(myList, initPos, finalPos)
                adapter.notifyItemMoved(initPos, finalPos)


                return true
            }

            override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {}
        }
            
        ).attachToRecyclerView(recyclerView)
        
        
    }
    
    private fun simpleList(): ArrayList<String> {
        
        val slist = ArrayList<String>()
        for (i in 0 until 10)
            slist.add("Text $i")
        
        return slist
    }
    
}
