package com.example.clean.di

import com.example.clean.repository.GreetingRepository
import com.example.clean.repository.GreetingRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

val dataModule = Kodein.Module("Data") {
	bind<GreetingRepository>() with singleton {
		GreetingRepositoryImpl()
	}
}
