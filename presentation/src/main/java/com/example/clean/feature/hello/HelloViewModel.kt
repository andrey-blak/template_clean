package com.example.clean.feature.hello

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelloViewModel : ViewModel() {
	private val _greeting = MutableLiveData<String>("Hello world")

	val greeting: LiveData<String> get() = _greeting
}
