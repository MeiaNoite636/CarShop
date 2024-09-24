package com.meianoitedev.carshop.auth.domain.repository

interface FirebaseAuthRepository {
    suspend fun login(email: String, password: String)

    suspend fun register(email: String, password: String)

    suspend fun recoverPassword(email: String)
}