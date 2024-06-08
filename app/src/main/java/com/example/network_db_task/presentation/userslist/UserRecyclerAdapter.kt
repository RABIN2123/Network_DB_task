package com.example.network_db_task.presentation.userslist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.network_db_task.databinding.FragmentUserElementBinding
import com.example.network_db_task.domain.model.User


class UserRecyclerAdapter(
    private val onItemClicked: (User) -> Unit
) : ListAdapter<User, UserRecyclerAdapter.MyViewHolder>(ItemDiffCallBack()) {

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
        fun bind(user: User, onItemClicked: (User) -> Unit) {
            with(binding) {
                name.text = user.name
                root.setOnClickListener {
                    onItemClicked(user)
                }
            }
        }
    }

    class ItemDiffCallBack : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }


}