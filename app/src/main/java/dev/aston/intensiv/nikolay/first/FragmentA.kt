package dev.aston.intensiv.nikolay.first

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import dev.aston.intensiv.nikolay.R
import dev.aston.intensiv.nikolay.core.BaseFragment
import dev.aston.intensiv.nikolay.databinding.FragmentABinding

class FragmentA : BaseFragment<FragmentABinding>(FragmentABinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toFragmentB.setOnClickListener { navigateToFragmentB() }
    }

    private fun navigateToFragmentB() {
        parentFragmentManager.commit {
            val fragment = FragmentB.newInstance()
            replace(R.id.fragment_container, fragment, FragmentB.TAG)
            addToBackStack(FragmentB.TAG)
        }
    }


    companion object {

        const val TAG = "FragmentA"
        fun newInstance(): FragmentA = FragmentA()
    }
}