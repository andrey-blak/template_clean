package com.example.clean.feature.hello

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelloViewModelImpl : ViewModel(), HelloViewModel {
	private val _greeting = MutableLiveData<String>("Hello world")

	override val greeting: LiveData<String> get() = _greeting
}
