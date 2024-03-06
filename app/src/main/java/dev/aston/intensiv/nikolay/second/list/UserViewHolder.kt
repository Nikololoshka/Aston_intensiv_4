package dev.aston.intensiv.nikolay.second.list

import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import coil.util.DebugLogger
import dev.aston.intensiv.nikolay.R
import dev.aston.intensiv.nikolay.databinding.ItemUserBinding
import dev.aston.intensiv.nikolay.second.model.User
import java.util.Objects

class UserViewHolder(
    private val binding: ItemUserBinding,
    onItemClicked: (position: Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener { onItemClicked(bindingAdapterPosition)  }
    }

    private fun getString(@StringRes resId: Int, vararg objects: Any): String {
        return itemView.context.getString(resId, *objects)
    }

    fun bind(item: User) {
        binding.photo.load(data = item.photoUrl)  {
            crossfade(true)
            placeholder(R.drawable.ic_person)
            error(R.drawable.ic_person)
            transformations(CircleCropTransformation())
            diskCachePolicy(CachePolicy.ENABLED)
        }
        binding.fullName.text = getString(R.string.user_fullname, item.name, item.surname)
        binding.phoneNumber.text = item.phoneNumber
    }
}