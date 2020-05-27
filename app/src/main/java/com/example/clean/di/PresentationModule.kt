package com.example.clean.di

import androidx.lifecycle.ViewModelProvider
import com.example.clean.feature.hello.HelloViewModel
import com.example.clean.util.viewmodel.KodeinViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val presentationModule = Kodein.Module("Presentation") {
	bind<ViewModelProvider.Factory>() with singleton {
		KodeinViewModelFactory(kodein)
	}
	bind<HelloViewModel>() with provider {
		HelloViewModel(instance())
	}
}
