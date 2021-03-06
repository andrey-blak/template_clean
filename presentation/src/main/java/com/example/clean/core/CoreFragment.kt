package com.example.clean.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class CoreFragment<T : ViewBinding> : Fragment() {
	private var _viewBinding: T? = null
	protected val viewBinding get() = _viewBinding!!

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		_viewBinding = createViewBinding(inflater, container)
		val view = viewBinding.root
		return view
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_viewBinding = null
	}

	protected abstract fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): T
}
