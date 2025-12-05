package com.example.pwassignment.features.auth_feature.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pwassignment.Graph
import com.example.pwassignment.R
import com.example.pwassignment.Screen
import com.example.pwassignment.features.auth_feature.AuthFeatureViewmodel
import com.example.pwassignment.features.auth_feature.components.AvatarRow
import com.example.pwassignment.features.auth_feature.components.SignInCard

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewmodel: AuthFeatureViewmodel = hiltViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            AvatarRow(
                topAvatar1 = R.drawable.student_png,
                topAvatar2 = R.drawable.student_avatar,
                bottomAvatar = R.drawable.girl_student
            )

            Spacer(Modifier.height(30.dp))

            Text(
                "Welcome to",
                style = MaterialTheme.typography.displaySmall,
                color = Color.White
            )
            Text(
                "Quizzy!",
                style = MaterialTheme.typography.displayMedium,
                color = Color.White
            )

            Spacer(Modifier.weight(1f))



            SignInCard(
                schoolId = email,
                studentId = password,
                onSchoolIdChange = {
                    email = it
                    viewmodel.onEmailChange(it)
                },
                onStudentIdChange = {
                    password = it
                    viewmodel.onPasswordChange(it)
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextButton(
                onClick = {
                    if (email.isNotBlank() && password.isNotBlank()) {
                        viewmodel.login(email, password) { success, error, token ->
                            if (success) {
                                navController.navigate(Graph.AppGraph.route) {
                                    popUpTo(Graph.AuthGraph.route) {
                                        inclusive = true
                                    }
                                }
                            } else {
                                // show error using Snackbar or Toast
                                println("Some Error Occurred: $error")
                            }
                        }
                    }
                    // will do something

                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 10.dp)
            ) {
                Text(
                    text = "SignIn",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}