package com.tfl.linestatus.statusdetail.ui

import androidx.compose.runtime.Composable

@Composable
fun LineStatusDetailsScreen(
    name: String,
    status: String,
    reason: String,
    onBackPressed: () -> Unit
) {
    LineStatusDetails(name = name, status = status, reason = reason, onBackPressed = onBackPressed)
}