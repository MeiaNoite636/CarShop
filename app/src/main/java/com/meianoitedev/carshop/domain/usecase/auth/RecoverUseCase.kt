package com.meianoitedev.carshop.domain.usecase.auth

import com.meianoitedev.carshop.domain.repository.auth.FirebaseAuthRepository
import javax.inject.Inject

class RecoverUseCase @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository
){
    suspend operator fun invoke(email: String){
        firebaseAuthRepository.recoverPassword(email)
    }

}