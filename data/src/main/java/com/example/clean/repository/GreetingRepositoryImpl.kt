package com.example.clean.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GreetingRepositoryImpl : GreetingRepository {
	override fun getGreeting(): Flow<String> {
		return flow {
			emit("Hello world!")
		}
	}
}
