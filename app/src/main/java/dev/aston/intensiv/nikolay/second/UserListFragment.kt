package dev.aston.intensiv.nikolay.second

import android.os.Bundle
import android.view.View
import androidx.core.os.BundleCompat
import androidx.fragment.app.commit
import dev.aston.intensiv.nikolay.R
import dev.aston.intensiv.nikolay.core.BaseFragment
import dev.aston.intensiv.nikolay.databinding.FragmentUserListBinding
import dev.aston.intensiv.nikolay.second.list.UserAdapter
import dev.aston.intensiv.nikolay.second.model.User
import dev.aston.intensiv.nikolay.second.model.UserSupplyer
import okhttp3.internal.toImmutableList

class UserListFragment : BaseFragment<FragmentUserListBinding>(FragmentUserListBinding::inflate) {

    private lateinit var adapter: UserAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UserAdapter(::onUserClicked)

        val users: List<User> = if (savedInstanceState != null) {
            BundleCompat
                .getParcelableArrayList(savedInstanceState, USER_LIST, User::class.java)
                ?: UserSupplyer.loadUsers()
        } else {
            UserSupplyer.loadUsers()
        }

        adapter.submitList(users)
        binding.userList.adapter = adapter

        parentFragmentManager.setFragmentResultListener(
            UserEditFragment.EDIT_REQUEST,
            this,
            ::onEditUserResult
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(USER_LIST, ArrayList(adapter.currentList))
    }

    private fun onUserClicked(user: User) {
        parentFragmentManager.commit {
            val fragment = UserEditFragment.newInstance(user)
            replace(R.id.fragment_container, fragment, UserEditFragment.TAG)
            addToBackStack(UserEditFragment.TAG)
        }
    }

    private fun onEditUserResult(request: String, result: Bundle) {
        val user = UserEditFragment.extractResult(result)
        if (user != null) {
            updateUserInList(user)
        }
    }

    private fun updateUserInList(user: User) {
        val newList = adapter.currentList.map { if (it.id == user.id) user else it }
        adapter.submitList(newList)
    }

    companion object {

        private const val USER_LIST = "user_list"

        const val TAG = "UserListFragment"

        fun newInstance(): UserListFragment = UserListFragment()
    }
}