package jp.tm.touchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment() {

    private lateinit var db: MemoDatabase
    private lateinit var dao: MemoDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.db = Room.databaseBuilder(
            requireContext(),
            MemoDatabase::class.java,
            "memo.db"
        ).build()
        this.dao = this.db.memoDao()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            // ボタンクリック時にDBへ登録する
            GlobalScope.launch {
                // ワーカースレッドでDBへ登録している
                withContext(Dispatchers.IO) {
                    val memo = Memo(id = 0, memo = "Sample!")
                    dao.insert(memo)
                }
                //
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "OK!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        this.dao.getAll().observe(viewLifecycleOwner, Observer {
            println(it)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}