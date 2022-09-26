package jp.tm.touchapp.page.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import jp.tm.touchapp.R

// layoutの引数だけ違っているので注意
// mokelab: R.layout.create_todo_fragment
// 自分: R.layout.fragment_create_to_do
class CreateToDoFragment : Fragment(R.layout.fragment_create_to_do) {

    private val vm: CreateToDoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_create_to_do, container, false)
    }

}