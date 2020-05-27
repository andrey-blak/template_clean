package com.example.clean.feature.hello

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.clean.core.CoreFragment
import com.example.clean.presentation.databinding.FragmentHelloBinding

class HelloFragment : CoreFragment<FragmentHelloBinding>() {

	private val viewModel by viewModels<HelloViewModel>()

	override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHelloBinding = FragmentHelloBinding.inflate(inflater)

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel.greeting.observe(viewLifecycleOwner, Observer { greeting ->
			viewBinding.greeting.text = greeting
		})
	}
}
