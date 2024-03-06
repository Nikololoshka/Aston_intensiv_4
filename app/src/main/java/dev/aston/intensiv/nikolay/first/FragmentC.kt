package dev.aston.intensiv.nikolay.first

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import dev.aston.intensiv.nikolay.R
import dev.aston.intensiv.nikolay.core.BaseFragment
import dev.aston.intensiv.nikolay.databinding.FragmentCBinding

class FragmentC : BaseFragment<FragmentCBinding>(FragmentCBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = arguments?.getString(EXTRA_TEXT)

        binding.currentText.text = text
        binding.toFragmentD.setOnClickListener { navigateToFragmentD() }
        binding.toFragmentA.setOnClickListener { navigateToFragmentA() }
    }

    private fun navigateToFragmentD() {
        parentFragmentManager.commit {
            val fragment = FragmentD.newInstance()
            replace(R.id.fragment_container, fragment, FragmentD.TAG)
            addToBackStack(FragmentD.TAG)
        }
    }

    private fun navigateToFragmentA() {
        parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    companion object {

        private const val EXTRA_TEXT = "extra_text"

        const val TAG = "FragmentC"
        fun newInstance(text: String): FragmentC = FragmentC().apply {
            arguments = bundleOf(EXTRA_TEXT to text)
        }
    }
}