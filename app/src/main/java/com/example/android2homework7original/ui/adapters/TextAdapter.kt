package com.example.android2homework7original.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android2homework7original.databinding.ItemTextBinding

class TextAdapter : RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

    private var list: ArrayList<String> = ArrayList()

    fun setList(list: ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    class TextViewHolder(private val binding: ItemTextBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(textModel: String) {
            binding.nameItem.text = textModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(
            ItemTextBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}