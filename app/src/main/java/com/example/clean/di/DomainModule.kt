package com.example.clean.di

import com.example.clean.usecase.GetGreetingUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val domainModule = Kodein.Module("Domain") {
	bind<GetGreetingUseCase>() with provider {
		GetGreetingUseCase(greetingRepository = instance())
	}
}
