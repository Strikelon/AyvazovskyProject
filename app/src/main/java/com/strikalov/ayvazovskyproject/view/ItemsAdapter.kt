package com.strikalov.ayvazovskyproject.view

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.strikalov.ayvazovskyproject.R
import com.strikalov.ayvazovskyproject.model.entity.Picture
import com.strikalov.ayvazovskyproject.viewmodel.MainViewModel

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemHolder>() {

    private var items: List<Picture> = emptyList()

    private var viewModel: MainViewModel? = null

    class ItemHolder(
        private val parent: ViewGroup,
        private val viewModel: MainViewModel?,
        private val binding: com.strikalov.ayvazovskyproject.databinding.ItemViewBinding
        = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_view,
            parent,
            false)
        ): RecyclerView.ViewHolder(binding.root){

        fun bind(item: Picture) {
            binding.picture = item
            viewModel?.let {
                binding.viewModel = viewModel
            }
        }

    }

    fun setViewModel(viewModel: MainViewModel){
        this.viewModel = viewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(parent, viewModel)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(items[position])
    }

    fun update(items: List<Picture>) {
        this.items = items
        notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun RecyclerView.bindItems(items: List<Picture>) {
            val adapter = adapter as ItemsAdapter
            adapter.update(items)
        }
    }
}