package com.example.androidtraining_databinding

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.example.androidtraining_databinding.databinding.RowBinding

class CustomAdapter(
    val activity: Activity,
    val list: List<Person>
): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, container: ViewGroup?): View {
        val binding: RowBinding
        var view: View? = convertView

        if (convertView == null) {
            view = LayoutInflater.from(activity).inflate(R.layout.row, null)
            binding = DataBindingUtil.bind<RowBinding>(view)!!
            view.setTag(binding)

        } else {
            binding = view?.getTag() as RowBinding
        }
        binding.person = list[position]
        return binding.root
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

}