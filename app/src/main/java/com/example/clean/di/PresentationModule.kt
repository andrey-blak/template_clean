package com.example.clean.di

import com.example.clean.feature.hello.HelloViewModel
import com.example.clean.feature.hello.HelloViewModelImpl
import com.example.clean.util.viewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind

val presentationModule = Kodein.Module("Presentation") {
	bind<HelloViewModel>() with viewModelFactory {
		HelloViewModelImpl()
	}
}
