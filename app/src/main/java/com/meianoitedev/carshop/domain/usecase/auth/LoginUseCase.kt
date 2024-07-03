package com.meianoitedev.carshop.domain.usecase.auth

import com.meianoitedev.carshop.domain.repository.auth.FirebaseAuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository
) {
    suspend operator fun invoke(email: String, password: String) {
        firebaseAuthRepository.login(email, password)
    }
}