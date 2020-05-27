package com.example.clean.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import org.kodein.di.DKodeinAware
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.factory
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

/**
 * [VM] - view model interface
 * Default scope may be overridden with parameter [ownerProducer]
 * @see androidx.fragment.app.viewModels
 */
inline fun <T, reified VM: Any> T.kodeinViewModel(
	noinline ownerProducer: () -> ViewModelStoreOwner = { this }
): Lazy<VM> where T : KodeinAware, T : ViewModelStoreOwner = lazy<VM> {
	direct.instance(arg = ownerProducer)
}

/**
 * [VM] - view model class
 */
inline fun <C, reified VM : ViewModel> Kodein.BindBuilder.WithContext<C>.viewModelFactory(
	noinline creator: DKodeinAware.() -> VM
) = factory { ownerProducer: () -> ViewModelStoreOwner ->
	val viewModelKey = VM::class.java.canonicalName
		?: error("'VM::class.java.canonicalName' is null")

	val localKodein = Kodein.lazy {
		extend(this@factory.kodein)
		bind<ViewModel>(VM::class.java.canonicalName) with provider {
			creator()
		}
	}

	val owner = ownerProducer()
	val factory = KodeinViewModelFactory(localKodein)
	ViewModelProvider(owner, factory).get(viewModelKey, VM::class.java)
}

class KodeinViewModelFactory(
	private val kodein: Kodein
) : ViewModelProvider.Factory {

	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		@Suppress("UNCHECKED_CAST")
		return kodein.direct.instance<ViewModel>(tag = modelClass.canonicalName) as T
	}
}
