package com.example.lovecalculator.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.databinding.ItemHistoryBinding
import com.example.lovecalculator.remote.LoveCalcModel

class LoveAdapter : RecyclerView.Adapter<LoveAdapter.LoveViewHolder>() {

    private val _data = mutableListOf<LoveCalcModel>()

    private val data get() = _data
    fun addData(list: List<LoveCalcModel>) {
        _data.clear()
        _data.addAll(list)
        notifyDataSetChanged()
    }


    inner class LoveViewHolder (val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoveViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryBinding.inflate(inflater, parent, false)

        return LoveViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: LoveViewHolder, position: Int) {
        val loveResult = data[position]

        with(holder.binding) {
            tvFNameHistory.text = loveResult.firstName
            tvSNameHistory.text = loveResult.secondName
            tvPercentageHistory.text = loveResult.percentage
        }
    }
}