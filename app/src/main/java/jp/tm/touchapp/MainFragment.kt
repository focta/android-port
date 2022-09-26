package jp.tm.touchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// コンストラクタにレイアウトファイルをせっていすることで、inflateしなくても取り扱えるようになるっぽい
class MainFragment : Fragment(R.layout.fragment_main) {

//    private lateinit var db: MemoDatabase
//    private lateinit var dao: MemoDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        // DB登録の処理、モケラボの講座の最中なので一旦閉じる
        super.onCreate(savedInstanceState)
//        this.db = Room.databaseBuilder(
//            requireContext(),
//            MemoDatabase::class.java,
//            "memo.db"
//        ).build()
//        this.dao = this.db.memoDao()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)
        // TODO カルーセルでの表示を一旦中止
//        val cardPager = view.findViewById<ViewPager2>(R.id.cardPager)
//        cardPager   .adapter = CardSlideAdapter(listOf(1, 2, 3, 4))
//
//        val margin = view.context.resources.getDimension(R.dimen.card_margin)
//        val offset = view.context.resources.getDimension(R.dimen.card_offset)
//
//        cardPager.offscreenPageLimit = 2
//        cardPager.setPageTransformer { page, position ->
//            val offset = position * (2 * offset + margin)
//            page.translationX = -offset
//        }

//        view.findViewById<Button>(R.id.button).setOnClickListener {
//            // ボタンクリック時にDBへ登録する
//            GlobalScope.launch {
//                // ワーカースレッドでDBへ登録している
//                withContext(Dispatchers.IO) {
//                    val memo = Memo(id = 0, memo = "Sample!")
//                    dao.insert(memo)
//                }
//                //
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(requireContext(), "OK!", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
        return view
    }

    override fun onStart() {
        super.onStart()
//        this.dao.getAll().observe(viewLifecycleOwner, Observer {
//            println(it)
//        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}