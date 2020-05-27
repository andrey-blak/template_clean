package com.example.clean.feature.hello

import androidx.lifecycle.LiveData

interface HelloViewModel {
	val greeting: LiveData<String>
}
