package com.example.pwassignment.features.auth_feature.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource

@Composable
fun AvatarRow(
    modifier: Modifier = Modifier,
    topAvatar1: Int,
    topAvatar2: Int,
    bottomAvatar: Int,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(topAvatar1),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Image(
                painter = painterResource(topAvatar2),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(bottomAvatar),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}
