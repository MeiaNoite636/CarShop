package com.meianoitedev.carshop.domain.repository.auth

import com.meianoitedev.carshop.data.model.User

interface FirebaseAuthRepository {
    suspend fun login(email: String, password: String)

    suspend fun register(email: String, password: String)

    suspend fun recoverPassword(email: String)
}