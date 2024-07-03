package com.meianoitedev.carshop.data.repository.remote.auth

import com.google.firebase.auth.FirebaseAuth
import com.meianoitedev.carshop.data.model.User
import com.meianoitedev.carshop.domain.repository.auth.FirebaseAuthRepository
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class FirebaseAuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : FirebaseAuthRepository {
    override suspend fun login(email: String, password: String) {
        return suspendCoroutine { continuation ->
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        continuation.resumeWith(Result.success(Unit))
                    } else {
                        task.exception?.let {
                            continuation.resumeWith(Result.failure(it))
                        }
                    }

                }
        }
    }

    override suspend fun register(email: String, password: String){
        return suspendCoroutine { continuation ->
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
//                        val user = User(
//                            email = email,
//                            password = password
//                        )
                        continuation.resumeWith(Result.success(Unit))
                    } else {
                        task.exception?.let {
                            continuation.resumeWith(Result.failure(it))
                        }
                    }
                }
        }
    }

    override suspend fun recoverPassword(email: String) {
        return suspendCoroutine {continuation ->
            firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener {task ->
                    if (task.isSuccessful){
                        continuation.resumeWith(Result.success(Unit))
                    }else{
                        task.exception?.let {
                            continuation.resumeWith(Result.failure(it))
                        }
                    }
                }
        }
    }
}