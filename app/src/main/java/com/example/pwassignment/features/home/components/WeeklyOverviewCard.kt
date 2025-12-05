package com.example.pwassignment.features.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pwassignment.R

@Composable
fun WeeklyOverviewCard(
    modifier: Modifier = Modifier,
    streak: List<Boolean?>,   // true = green tick, false/null = empty dashed circle
    accuracyPercent: Int,
    performance: List<Pair<String, Int>> // topic + score (0–100)
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, Color(0xFFE5E5E5), RoundedCornerShape(16.dp))
            .padding(20.dp)
    ) {

        // ----------------------------
        // QUIZ STREAK
        // ----------------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Quiz Streak",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(R.drawable.streak_icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            streak.forEach { day ->
                if (day == true) {
                    Icon(
                        painter = painterResource(R.drawable.check_icon),
                        contentDescription = null,
                        tint = Color(0xFF22C55D),
                        modifier = Modifier.size(34.dp)
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .border(
                                1.dp,
                                Color.LightGray,
                                RoundedCornerShape(50)
                            )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ----------------------------
        // ACCURACY
        // ----------------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Accuracy",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(R.drawable.accuracy_icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }

        Text(
            text = "$accuracyPercent% correct",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 6.dp)
        )

        LinearProgressIndicator(
            progress = accuracyPercent / 100f,
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(50)),
            color = Color(0xFFFF8A8A),
            trackColor = Color(0xFFFFE7E7)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // ----------------------------
        // PERFORMANCE BY TOPIC
        // ----------------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Performance by Topic",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(R.drawable.bar_icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        performance.forEach { (topic, score) ->
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "$topic  ($score%)",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )

                LinearProgressIndicator(
                    progress = score / 100f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(50)),
                    color = Color(0xFF3B82F6),
                    trackColor = Color(0xFFE0ECFF)
                )

                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}
