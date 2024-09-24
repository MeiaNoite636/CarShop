package com.meianoitedev.carshop.auth.domain.use_case

import com.meianoitedev.carshop.auth.domain.repository.FirebaseAuthRepository
import javax.inject.Inject

class RecoverUseCase @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository
){
    suspend operator fun invoke(email: String){
        firebaseAuthRepository.recoverPassword(email)
    }
}