package jp.tm.touchapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//
class ViewHolderItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // RecyclerViewの1行のレイアウトを読み込む
    val itemName: TextView = itemView.findViewById(R.id.tvRecycleView)
}