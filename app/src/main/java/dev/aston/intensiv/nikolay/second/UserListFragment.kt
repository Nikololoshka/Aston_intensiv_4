package dev.aston.intensiv.nikolay.second

import android.os.Bundle
import android.view.View
import dev.aston.intensiv.nikolay.core.BaseFragment
import dev.aston.intensiv.nikolay.databinding.FragmentUserListBinding
import dev.aston.intensiv.nikolay.second.list.UserAdapter
import dev.aston.intensiv.nikolay.second.model.UserSupplyer

class UserListFragment : BaseFragment<FragmentUserListBinding>(FragmentUserListBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UserAdapter()
        adapter.submitList(UserSupplyer.loadUsers())

        binding.userList.adapter = adapter
    }

    companion object {
        const val TAG = "UserListFragment"

        fun newInstance(): UserListFragment = UserListFragment()
    }

}