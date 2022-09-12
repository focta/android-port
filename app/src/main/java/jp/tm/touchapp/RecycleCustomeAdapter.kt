package jp.tm.touchapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecycleCustomeAdapter : RecyclerView.Adapter<CustomeViewHolderItem>() {

    val nameList = listOf("My Name0", "My Name1", "My Name2", "My Name3", "My Name4", "My Name5")
    val messageList = listOf(
        "My Message1",
        "My Message2",
        "My Message3",
        "My Message3",
        "My Message4",
        "My Name5"
    )
    val imageList = listOf(
        R.drawable.img0,
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomeViewHolderItem {
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_recycle_view, parent, false)
        return CustomeViewHolderItem(itemXml)
    }

    override fun onBindViewHolder(holder: CustomeViewHolderItem, position: Int) {
        holder.tvName.text = nameList[position]
        holder.tvMessage.text = messageList[position]
        holder.iv.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return nameList.size
    }
}