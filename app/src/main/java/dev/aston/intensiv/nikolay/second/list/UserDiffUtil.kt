package dev.aston.intensiv.nikolay.second.list

import androidx.recyclerview.widget.DiffUtil
import dev.aston.intensiv.nikolay.second.model.User

object UserDiffUtil : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}