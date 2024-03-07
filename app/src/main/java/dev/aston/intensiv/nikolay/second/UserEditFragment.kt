package dev.aston.intensiv.nikolay.second

import android.os.Bundle
import android.view.View
import androidx.core.os.BundleCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import dev.aston.intensiv.nikolay.core.BaseFragment
import dev.aston.intensiv.nikolay.databinding.FragmentUserEditBinding
import dev.aston.intensiv.nikolay.second.model.User

class UserEditFragment : BaseFragment<FragmentUserEditBinding>(FragmentUserEditBinding::inflate) {

    private lateinit var currentUser: User

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentUser = BundleCompat
            .getParcelable(requireArguments(), EXTRA_USER, User::class.java)
            ?: throw IllegalArgumentException("User was not passed to the fragment")

        setupUserToForm(currentUser)

        binding.saveUser.setOnClickListener { saveUser() }
        binding.toolbar.setNavigationOnClickListener { onBackClicked() }
    }

    private fun setupUserToForm(user: User) {
        binding.photoUrl.setText(user.photoUrl)
        binding.name.setText(user.name)
        binding.surname.setText(user.surname)
        binding.phoneNumber.setText(user.phoneNumber)
    }

    private fun userFromForm(id: Int = -1): User {
        return User(
            id = id,
            photoUrl = binding.photoUrl.text.toString(),
            name = binding.name.text.toString(),
            surname = binding.surname.text.toString(),
            phoneNumber = binding.phoneNumber.text.toString()
        )
    }

    private fun onBackClicked() {
        parentFragmentManager.popBackStack()
    }

    private fun saveUser() {
        val newUser = userFromForm(id = currentUser.id)
        setFragmentResult(EDIT_REQUEST, bundleOf(EXTRA_USER to newUser))
        onBackClicked()
    }

    companion object {

        private const val EXTRA_USER = "extra_user"

        const val EDIT_REQUEST = "edit_request"

        const val TAG = "UserEditFragment"

        fun extractResult(bundle: Bundle): User? {
            return BundleCompat.getParcelable(bundle, EXTRA_USER, User::class.java)
        }

        fun newInstance(user: User): UserEditFragment = UserEditFragment().apply {
            arguments = bundleOf(EXTRA_USER to user)
        }
    }
}