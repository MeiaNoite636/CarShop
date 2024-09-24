package com.meianoitedev.carshop.auth.domain.use_case

import com.meianoitedev.carshop.auth.domain.repository.FirebaseAuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository
) {
    suspend operator fun invoke(email: String, password: String) {
        firebaseAuthRepository.login(email, password)
    }
}