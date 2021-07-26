package com.example.a7minutesworkoutapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class InstructionsAdapter(val context: Context) : RecyclerView.Adapter<InstructionViewHolder>() {
    private val items: ArrayList<ExerciseModel> = Constants.defaultExerciseList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstructionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.instruction_model, parent, false)
        val viewHolder = InstructionViewHolder(view)

//        view.setOnClickListener {
//            listener.onItemClicked(items[viewHolder.adapterPosition])
//        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: InstructionViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem.getName()
        holder.itemView.setOnClickListener {
            val intent : Intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("key", currentItem.getUrl())
            intent.putExtra("name",currentItem.getName())
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class InstructionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.letterText)
}

//interface InstructionItemClicked {
//    fun onItemClicked(item: ExerciseModel)
//}