package com.example.network_db_task.presentation.userslist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.network_db_task.databinding.FragmentUserElementBinding
import com.example.network_db_task.domain.model.Item


class UserRecyclerAdapter(
    private val onItemClicked: (Item) -> Unit
) : ListAdapter<Item, UserRecyclerAdapter.MyViewHolder>(ItemDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val binding = FragmentUserElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(currentList[position], onItemClicked)
    }


    class MyViewHolder(
        private val binding: FragmentUserElementBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item, onItemClicked: (Item) -> Unit) {
            with(binding) {
                name.text = item.name
                root.setOnClickListener {
                    onItemClicked(item)
                }
            }
        }
    }

    class ItemDiffCallBack : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }


}