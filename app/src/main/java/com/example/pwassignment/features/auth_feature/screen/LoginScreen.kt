package com.example.pwassignment.features.auth_feature.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pwassignment.Graph
import com.example.pwassignment.R
import com.example.pwassignment.Screen
import com.example.pwassignment.features.auth_feature.components.AvatarRow
import com.example.pwassignment.features.auth_feature.components.SignInCard

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var schoolId by remember { mutableStateOf("") }
    var studentId by remember { mutableStateOf("") }

    Box(
        modifier = modifier.fillMaxSize()
    ) {

//        Image(
//            painter = painterResource(R.drawable.bg_doodles),
//            contentDescription = null,
//            modifier = Modifier.fillMaxSize()
//        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            AvatarRow(
                topAvatar1 = R.drawable.avatar_1,
                topAvatar2 = R.drawable.avatar_2,
                bottomAvatar = R.drawable.avatar_3
            )

            Spacer(Modifier.height(30.dp))

            Text(
                "Welcome to",
                style = MaterialTheme.typography.headlineMedium,
            )
            Text(
                "Quizzy!",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(Modifier.weight(1f))

            SignInCard(
                schoolId = schoolId,
                studentId = studentId,
                onSchoolIdChange = { schoolId = it },
                onStudentIdChange = { studentId = it }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    // will do something
                    navController.navigate(Graph.AppGraph.route) {
                        popUpTo(Graph.AuthGraph.route) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 10.dp)
            ) {
                Text(
                    text = "SignIn"
                )
            }
        }
    }
}