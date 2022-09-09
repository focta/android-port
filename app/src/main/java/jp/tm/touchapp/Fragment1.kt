package jp.tm.touchapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val screen1 = inflater.inflate(R.layout.fragment_1, container, false)

        val lv = screen1.findViewById<ListView>(R.id.lvFragment1)

        val arrayTitle = arrayOf(
            "ライオン", "クマ", "キリン", "ゾウ", "パンダ", "コアラ", "キリン", "サル", "ヒョウ",
            "ゴリラ", "カバ", "カピバラ", "リス", "ワニ", "ハムスター", "ヒツジ", "ネコ"
        )

        // FragmentのときにはActivityと引数が異なる
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            arrayTitle
        )

        lv.adapter = adapter

        // 横画面時の判定を行い、縦画面時は画面遷移、横画面時は画面内でのFragment2への値の送付を行う。
        val fcvLand2 = requireActivity().findViewById<View>(R.id.fcvLand2)
        if (fcvLand2 == null) {
            lv.setOnItemClickListener { _, _, i, _ ->
                // Activity間はintentで送付する
                val intent = Intent(requireContext(), FragmentBaseSecondActivity::class.java)
                intent.putExtra("POSITION", i)
                startActivity(intent)
            }
        } else {
            lv.setOnItemClickListener { _, _, i, _ ->
                // Fragment間での通信時は bundle を利用する。
                val bundle = Bundle()
                bundle.putInt("POSITION", i)
                val fragment2 = Fragment2()
                fragment2.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fcvLand2, fragment2)
                    .commit()
            }
        }

        return screen1
    }
}