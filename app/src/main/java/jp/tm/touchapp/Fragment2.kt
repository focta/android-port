package jp.tm.touchapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Fragment2 : Fragment() {

    // 画面の縦か横かの判断フラグ
    private var ls = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // viewの作成時点で縦横の判断を行う。こちらは同じActivity内でfcvLand1が存在するかしないかで判断している(存在している場合が横画面)
        val fcvLand = requireActivity().findViewById<View>(R.id.fcvLand1)
        if (fcvLand == null) {
            ls = false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val screen2 = inflater.inflate(R.layout.fragment_2, container, false)
        val tv = screen2.findViewById<TextView>(R.id.tvFragment2)

        val arrayMessage = arrayOf(
            "ライオン", "クマ", "キリン", "ゾウ", "パンダ", "コアラ", "キリン", "サル", "ヒョウ",
            "ゴリラ", "カバ", "カピバラ", "リス", "ワニ", "ハムスター", "ヒツジ", "ネコ"
        )

        if (ls) {
            val args = requireArguments()
            val argsPosition = args.getInt("POSITION", 0)
            tv.text = arrayMessage[argsPosition]
        } else {
            // Fragment1からの値を受け取る
            // Activity経由でしかintentが取得できないので, requireActivity()を呼びActivity持ちの変数を追加する。
            val itemPosition = requireActivity().intent.getIntExtra("POSITION", 0)
            tv.text = arrayMessage[itemPosition]
        }

        return screen2
    }

}