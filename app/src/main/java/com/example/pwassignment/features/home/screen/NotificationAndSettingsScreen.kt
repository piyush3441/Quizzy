package com.example.pwassignment.features.home.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pwassignment.R
import com.example.pwassignment.features.home.components.NotificationCard
import com.example.pwassignment.features.home.components.SettingRow

@Composable
fun NotificationAndSettingsScreen(
    modifier: Modifier = Modifier,
    onLogout: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(20.dp)
    ) {

        // ---------------------------
        //  Notifications Section
        // ---------------------------
        Text(
            text = "Notifications",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        NotificationCard(
            color = Color(0xFFFFE8D6),
            indicatorColor = Color(0xFFFFA45B),
            title = "Missed quiz in physics in yesterday",
            timeAgo = "2 hours ago"
        )

        Spacer(Modifier.height(10.dp))

        NotificationCard(
            color = Color(0xFFF3E8FF),
            indicatorColor = Color(0xFF9B5DE5),
            title = "Badge earned",
            timeAgo = "8 hours ago"
        )

        Spacer(Modifier.height(10.dp))

        NotificationCard(
            color = Color(0xFFE6FFE6),
            indicatorColor = Color(0xFF40C057),
            title = "Teacher Note",
            timeAgo = "1 day ago"
        )

        Spacer(modifier = Modifier.height(26.dp))

        // ---------------------------
        //  Settings Section
        // ---------------------------
        Text(
            text = "Settings",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        SettingRow(
            icon = R.drawable.switch_icon,
            title = "Switch Child",
            subtitle = "Change active child profile",
            onClick = {}
        )

        SettingRow(
            icon = R.drawable.language_icon,
            title = "Language",
            subtitle = "English",
            onClick = {}
        )

        SettingRow(
            icon = R.drawable.log_out_icon,
            title = "Logout",
            subtitle = "Sign out of your account",
            onClick = { onLogout() }
        )
    }
}