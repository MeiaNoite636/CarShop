package com.meianoitedev.carshop.domain.usecase.auth

import com.meianoitedev.carshop.data.model.User
import com.meianoitedev.carshop.domain.repository.auth.FirebaseAuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository
) {
    suspend operator fun invoke(email: String, password: String){
        return firebaseAuthRepository.register(email, password)
    }
}