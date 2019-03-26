package com.apps.a7pl4y3r.testrvonmove

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ItemAdapter(
    private val itemList: ArrayList<String>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val task: TextView = view.findViewById(R.id.tv_task)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.task.text = itemList[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    override fun getItemCount(): Int = itemList.size
}