package jp.tm.touchapp

import androidx.room.Entity
import androidx.room.PrimaryKey

// 1. データクラスを作成する
// SQLiteで取り扱うデータのカラムに沿ったデータ定義を行う
@Entity
data class Memo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val memo: String
) {}