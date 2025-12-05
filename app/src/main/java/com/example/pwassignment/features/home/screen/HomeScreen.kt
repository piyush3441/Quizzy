package com.example.pwassignment.features.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pwassignment.R
import com.example.pwassignment.Screen
import com.example.pwassignment.features.home.viewmodel.HomeViewmodel
import com.example.pwassignment.features.home.components.FocusedButton
import com.example.pwassignment.features.home.components.FocusedCard
import com.example.pwassignment.features.home.components.StatCard
import com.example.pwassignment.features.home.components.WeeklyOverviewCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewmodel: HomeViewmodel = hiltViewModel(),
    navController: NavController
) {
    val state = viewmodel.studentDashboardState.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (state.studentDashboard != null && !state.isLoading && state.error.isEmpty()) {
                        Column {
                            Text(
                                text = state.studentDashboard.student?.name ?: "---",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = state.studentDashboard.student?.standard ?: "---",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    } else {
                        // While loading or error → show placeholder
                        Column {
                            Text(
                                text = "---",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = "---",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                },

                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate(Screen.NotificationScreen.route)
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.notification_icon),
                            contentDescription = "server_sync_action"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            when {
                // -------------------------------
                //     CENTERED LOADING
                // -------------------------------
                state.isLoading -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 120.dp),       // centers vertically in content area
                        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator()
                    }
                }

                state.error.isNotEmpty() -> {
                    Text(
                        text = state.error,
                        color = Color.Red,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                state.studentDashboard != null -> {
                    val dashboard = state.studentDashboard

                    // ---------------------------
                    //   TOP STAT CARDS
                    // ---------------------------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        StatCard(
                            icon = R.drawable.availability_icon,
                            title = "Availability",
                            value = (dashboard.student?.availability?.status ?: "N/A").toString(),
                            borderColor = Color(0xff22C55D),
                            backgroundColor = Color(0xffF2FFF4),
                            modifier = Modifier.weight(1f)
                        )

                        StatCard(
                            icon = R.drawable.availability_icon,
                            title = "Quiz",
                            value = "${dashboard.student?.quiz?.attempts ?: 0} Attempt",
                            borderColor = Color(0xffFE9C3B),
                            backgroundColor = Color(0xffFFFCF9),
                            modifier = Modifier.weight(1f)
                        )

                        StatCard(
                            icon = R.drawable.availability_icon,
                            title = "Accuracy",
                            value = "${dashboard.student?.accuracy?.current ?: 0}%",
                            borderColor = Color(0xffFF4F4F),
                            backgroundColor = Color(0xffFFF6F6),
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Text(
                        text = "Today's Summary",
                        modifier = Modifier.padding(vertical = 10.dp),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold
                    )

                    FocusedCard(
                        modifier = Modifier.fillMaxWidth(),
                        title = "Focused",
                        message = dashboard.todaySummary?.description
                            ?: "No focused message available.",
                        onClick = { }
                    )

                    Text(
                        text = "Weekly Overview",
                        modifier = Modifier.padding(vertical = 10.dp),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold
                    )

                    WeeklyOverviewCard(
                        streak = listOf(true, true, true, true, false, false, false),
                        accuracyPercent = dashboard.weeklyOverview?.overallAccuracy?.percentage
                            ?: 0,
                        performance = listOf(
                            "Math" to 72,
                            "Physics" to 64,
                            "Biology" to 88
                        )
                    )

                }
            }
        }
    }
}

