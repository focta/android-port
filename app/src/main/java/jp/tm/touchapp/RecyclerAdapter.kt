package jp.tm.touchapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<ViewHolderItem>() {

    private val data = listOf(
        "ライオン", "クマ", "キリン", "ゾウ", "パンダ", "コアラ", "キリン", "サル", "ヒョウ",
        "ゴリラ", "カバ", "カピバラ", "リス", "ワニ", "ハムスター", "ヒツジ", "ネコ"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val itemXml = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_layout, parent, false)
        return ViewHolderItem(itemXml)
    }

    // 指定したViewHolderへ表示したいデータを渡すことで、レイアウトの準備ができる
    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        holder.itemName.text = data[position]
    }

    // どのぐらい表示するか？を設定する。（設定した数のリストをリサイクルする)
    override fun getItemCount(): Int {
        return data.size
    }

}