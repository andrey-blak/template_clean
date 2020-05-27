package com.example.clean.repository

import kotlinx.coroutines.flow.Flow

interface GreetingRepository {
	fun getGreeting(): Flow<String>
}
