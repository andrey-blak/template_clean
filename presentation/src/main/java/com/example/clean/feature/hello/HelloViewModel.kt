package com.example.clean.feature.hello

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.clean.usecase.GetGreetingUseCase

class HelloViewModel(
	private val getGreetingUseCase: GetGreetingUseCase
) : ViewModel() {

	val greeting: LiveData<String>
		get() {
			return getGreetingUseCase
				.getGreeting()
				.asLiveData()
		}
}
