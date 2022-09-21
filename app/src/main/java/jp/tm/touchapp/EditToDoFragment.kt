package jp.tm.touchapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// layoutの引数だけ違っているので注意
// mokelab: R.layout.edit_todo_fragment
// 自分: R.layout.fragment_edit_to_do
class EditToDoFragment : Fragment(R.layout.fragment_edit_to_do) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_edit_to_do, container, false)
    }

}