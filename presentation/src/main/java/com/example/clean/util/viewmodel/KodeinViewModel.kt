package com.example.clean.util.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.TT
import org.kodein.di.direct
import org.kodein.di.generic.instance

inline fun <reified VM : ViewModel, T> T.kodeinViewModel(): Lazy<VM> where T : KodeinAware, T : ViewModelStoreOwner {
	return lazy {
		ViewModelProvider(this, direct.instance()).get(VM::class.java)
	}
}

class KodeinViewModelFactory(
	private val kodein: Kodein
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		return kodein.direct.Instance(TT(modelClass))
	}
}
