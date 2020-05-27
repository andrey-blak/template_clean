package com.example.clean.usecase

import com.example.clean.repository.GreetingRepository
import kotlinx.coroutines.flow.Flow

class GetGreetingUseCase(
	private val greetingRepository: GreetingRepository
) {

	fun getGreeting(): Flow<String> {
		return greetingRepository.getGreeting()
	}
}
