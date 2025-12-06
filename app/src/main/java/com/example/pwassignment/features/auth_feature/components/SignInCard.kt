package com.example.pwassignment.features.auth_feature.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBarDefaults.InputField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun SignInCard(
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    emailSupportingText: String,
    passwordSupportingText: String,
    emailError: Boolean = false,
    passwordError: Boolean = false
) {

    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surface,
                BottomCutCurve()
            )
            .padding(horizontal = 20.dp, vertical = 30.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Let’s Get you Signed in",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(18.dp))


            OutlinedTextField(
                value = email,
                onValueChange = onEmailChanged,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Email") },
                singleLine = true,
                supportingText = {
                    Text(
                        text = emailSupportingText,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                },
                isError = emailError
            )


            OutlinedTextField(
                value = password,
                onValueChange = onPasswordChanged,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Password") },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                supportingText = {
                    Text(
                        text = passwordSupportingText,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                },
                visualTransformation = if (passwordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),

                trailingIcon = {
                    val icon = if (passwordVisible)
                        Icons.Default.Visibility
                    else
                        Icons.Default.VisibilityOff

                    IconButton(
                        onClick = { passwordVisible = !passwordVisible }
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                },
                isError = passwordError
            )

        }
    }
}

