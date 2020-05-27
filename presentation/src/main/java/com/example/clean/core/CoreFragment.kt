package com.example.clean.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein

abstract class CoreFragment<T : ViewBinding> : Fragment(), KodeinAware {

	private var _viewBinding: T? = null
	protected val viewBinding get() = _viewBinding!!

	override val kodein: Kodein by closestKodein()

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
