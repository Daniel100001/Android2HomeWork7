package com.example.android2homework7original.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android2homework7original.databinding.ItemTextBinding
import com.example.android2homework7original.models.TextModel

class TextAdapter : RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

    private var list: List<TextModel> = ArrayList()

    fun setList(list: List<TextModel>) {
        this.list = list
        notifyDataSetChanged()
    }


    class TextViewHolder(private val binding: ItemTextBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(textModel: TextModel) {
            binding.nameItem.text = textModel.name
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