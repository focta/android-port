package jp.tm.touchapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomeViewHolderItem(itemView: View): RecyclerView.ViewHolder(itemView) {

    val iv = itemView.findViewById<ImageView>(R.id.ivCustomeRecyclerView)
    val tvName = itemView.findViewById<TextView>(R.id.tvNameCustomeRecyclerView)
    val tvMessage: TextView = itemView.findViewById(R.id.tvMessageCustomeRecyclerView)

    // クリック時の処理
    private val recyclerAdapter = RecycleCustomeAdapter()
    private val nameList = recyclerAdapter.nameList

    init {
        itemView.setOnClickListener{
            val position: Int = adapterPosition
            Toast.makeText(itemView.context, "${nameList[position]}さんです", Toast.LENGTH_SHORT).show()
        }
    }
}