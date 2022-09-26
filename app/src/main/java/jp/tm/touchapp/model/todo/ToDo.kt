package jp.tm.touchapp.model.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

// 参考: https://blog.mokelab.com/50/android_todo6.html
@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val _id: Int = 0,
    val title: String,
    val detail: String,
    val created: Long,
    val modified: Long,
)
