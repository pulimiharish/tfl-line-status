package com.tfl.linestatus.statusdetail.ui

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tfl.linestatus.shared.ui.AppText
import com.tfl.linestatus.utils.getStatusColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LineStatusDetails(
    name: String,
    status: String,
    reason: String,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            DetailTopBar(
                title = name,
                onBackPressed = onBackPressed
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        // Apply padding from Scaffold to avoid overlap
        LineStatusContent(
            status = status,
            reason = reason,
            modifier = Modifier.padding(paddingValues) // Ensures content is placed below the top bar
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar(
    title: String,
    onBackPressed: () -> Unit
) {
    TopAppBar(
        title = {
            AppText(
                text = title,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(end = 8.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                )
            }
        },
    )
}

@Composable
private fun LineStatusContent(status: String, reason: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // Status with colored background
        val statusColor by animateColorAsState(
            targetValue = getStatusColor(status),
            label = "StatusColorAnimation"
        )

        Box(
            modifier = Modifier
                .background(statusColor, shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = status,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (reason != "REASON") {
            Text(
                text = reason,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                ),
                color = Color.Black
            )
        }
    }
}
