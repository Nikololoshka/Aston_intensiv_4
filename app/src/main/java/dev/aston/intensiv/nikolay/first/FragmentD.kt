package dev.aston.intensiv.nikolay.first

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dev.aston.intensiv.nikolay.R
import dev.aston.intensiv.nikolay.core.BaseFragment
import dev.aston.intensiv.nikolay.databinding.FragmentCBinding
import dev.aston.intensiv.nikolay.databinding.FragmentDBinding

class FragmentD : BaseFragment<FragmentDBinding>(FragmentDBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDBinding.bind(view)
        binding.toFragmentB.setOnClickListener { navigateToFragmentB() }
    }

    private fun navigateToFragmentB() {
        parentFragmentManager.popBackStack(FragmentB.TAG, 0)
    }

    companion object {

        const val TAG = "FragmentD"
        fun newInstance(): FragmentD = FragmentD()
    }
}