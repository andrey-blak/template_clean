package com.example.clean

import android.app.Application
import com.example.clean.di.dataModule
import com.example.clean.di.domainModule
import com.example.clean.di.presentationModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class App : Application(), KodeinAware {
	override val kodein = Kodein.lazy {
		import(androidXModule(this@App))
		import(presentationModule)
		import(domainModule)
		import(dataModule)
	}
}
