package dev.aston.intensiv.nikolay.first

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import dev.aston.intensiv.nikolay.R
import dev.aston.intensiv.nikolay.core.BaseFragment
import dev.aston.intensiv.nikolay.databinding.FragmentBBinding

class FragmentB : BaseFragment<FragmentBBinding>(FragmentBBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toFragmentC.setOnClickListener { navigateToFragmentC() }
        binding.back.setOnClickListener { navigateBack() }
    }

    private fun navigateBack() {
        parentFragmentManager.popBackStack()
    }

    private fun navigateToFragmentC() {
        parentFragmentManager.commit {
            val fragment = FragmentC.newInstance("\"Hello Fragment C\"")
            replace(R.id.fragment_container, fragment, FragmentC.TAG)
            addToBackStack(FragmentC.TAG)
        }
    }

    companion object {

        const val TAG = "FragmentB"
        fun newInstance(): FragmentB = FragmentB()
    }
}