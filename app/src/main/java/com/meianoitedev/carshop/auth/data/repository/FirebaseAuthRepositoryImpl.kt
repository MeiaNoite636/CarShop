package com.meianoitedev.carshop.auth.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.meianoitedev.carshop.auth.domain.repository.FirebaseAuthRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class FirebaseAuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : FirebaseAuthRepository {
    override suspend fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun register(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).await()
    }

    override suspend fun recoverPassword(email: String) {
        firebaseAuth.sendPasswordResetEmail(email).await()
    }
}