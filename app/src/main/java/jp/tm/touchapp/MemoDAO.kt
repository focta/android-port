package jp.tm.touchapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// 1. メソッドを作成する
//    メソッドには、CRUD操作のどれを取り扱うかのアノテーションを付ける
//    Queryに関しては、SQL文を記載することができる！
// 2. interfaceの上に @Dao　をつけることで、データ操作を行うインターフェースとして認識される。
@Dao
interface MemoDAO {

    @Insert
    fun insert(memo: Memo)

    @Query("select * from memo")
    fun getAll(): LiveData<List<Memo>>
}