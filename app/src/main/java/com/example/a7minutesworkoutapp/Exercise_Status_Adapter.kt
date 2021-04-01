package com.example.a7minutesworkoutapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_exercise_status.view.*

class Exercise_Status_Adapter(val item: ArrayList<ExerciseModel>, val context : Context)
    : RecyclerView.Adapter<Exercise_Status_Adapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvItem = view.tv_item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_exercise_status,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model : ExerciseModel = item[position]
        holder.tvItem.text = model.getId().toString()

        if(model.getIsSelected()){
            holder.tvItem.background = ContextCompat.getDrawable(context,R.drawable.item_circular_thin_color_accent_vorder)
            holder.tvItem.setTextColor(Color.parseColor("#212121"))
        }else if(model.getIsCompleted()){
            holder.tvItem.background = ContextCompat.getDrawable(context,R.drawable.item_circular_color_accent_background)
            holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
        }else{
            holder.tvItem.background = ContextCompat.getDrawable(context,R.drawable.item_circular_color_gray_background)
            holder.tvItem.setTextColor(Color.parseColor("#212121"))
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}