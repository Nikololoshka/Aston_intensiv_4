package dev.aston.intensiv.nikolay.second.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import dev.aston.intensiv.nikolay.databinding.ItemUserBinding
import dev.aston.intensiv.nikolay.second.model.User

class UserAdapter(
    private val onUserClicked: (item: User) -> Unit
) : ListAdapter<User, UserViewHolder>(
    AsyncDifferConfig
        .Builder(UserDiffUtil)
        .build()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding, ::onItemClicked)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun onItemClicked(position: Int) {
        onUserClicked(getItem(position))
    }
}