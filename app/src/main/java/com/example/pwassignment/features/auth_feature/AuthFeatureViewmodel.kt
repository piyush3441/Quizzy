package com.example.pwassignment.features.auth_feature

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pwassignment.features.auth_feature.state.AuthState
import com.example.pwassignment.features.auth_feature.state.LoginFormState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AuthFeatureViewmodel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _loginFormState = MutableStateFlow(LoginFormState())
    val loginFormState: StateFlow<LoginFormState> = _loginFormState

    private val _authState = mutableStateOf(AuthState())
    val authState: State<AuthState> = _authState

    fun onEmailChange(value: String) {
        _loginFormState.update { currentState ->
            val usernameError = LoginUtils.validateUsername(value)
            currentState.copy(
                email = value,
                emailError = usernameError,
                isFormValid = (usernameError == null) && (currentState.passwordError == null)
            )
        }
    }

    fun onPasswordChange(value: String) {
        _loginFormState.update { currentState ->
            val passwordError = LoginUtils.validatePassword(value)
            currentState.copy(
                password = value,
                passwordError = passwordError,
                isFormValid = (passwordError == null) && (currentState.passwordError == null)
            )
        }
    }


    fun login(
        email: String,
        password: String,
        onResult: (Boolean, String?, String?) -> Unit
    ) {

        val currentFormState = _loginFormState.value

        if (currentFormState.isFormValid) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isComplete) {
                        _authState.value = authState.value.copy(
                            isLoading = false
                        )
                    }

                    if (task.isSuccessful) {
                        // Fetch ID Token
                        firebaseAuth.currentUser?.getIdToken(true)
                            ?.addOnCompleteListener { tokenTask ->
                                if (tokenTask.isSuccessful) {
                                    val token = tokenTask.result?.token
                                    _authState.value = authState.value.copy(
                                        token = token
                                    )
                                    onResult(true, null, token) // success + token
                                } else {
                                    onResult(false, tokenTask.exception?.message, null)
                                }
                            }

                    } else {
                        _authState.value = authState.value.copy(
                            error = task.exception?.message ?: "Unknown error occurred"
                        )
                        onResult(false, task.exception?.message, null)
                    }
                }
        } else {
            onEmailChange(currentFormState.email)
            onPasswordChange(currentFormState.password)
        }

    }

    fun logout() {
        firebaseAuth.signOut()
    }

}