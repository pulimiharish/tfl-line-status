package com.tfl.linestatus.utils

import androidx.compose.ui.graphics.Color

// Function to return line colors
fun getColorForLine(lineName: String?): Color {
    return when (lineName) {
        "Bakerloo" -> Color(0xFFB36305)
        "Central" -> Color(0xFFE32017)
        "Circle" -> Color(0xFFFFD300)
        "District" -> Color(0xFF007229)
        "Hammersmith & City" -> Color(0xFFF86C67)
        "Jubilee" -> Color(0xFFA0A5A9)
        "Metropolitan" -> Color(0xFF8A004F)
        "Northern" -> Color(0xFF000000)
        "Piccadilly" -> Color(0xFF0019A8)
        "Victoria" -> Color(0xFF00A0E2)
        "Waterloo & City" -> Color(0xFF00A99D)
        else -> Color.Gray
    }
}

// Function to return status colors dynamically
fun getStatusColor(status: String?): Color {
    return when (status) {
        "Good Service" -> Color(0xFF4CAF50) // Green
        "Minor Delays" -> Color(0xFFFFA000) // Orange
        "Severe Delays" -> Color(0xFFD32F2F) // Red
        "Part Closure" -> Color(0xFF757575) // Grey
        "Planned Closure" -> Color(0xFF303F9F) // Blue
        else -> Color.Gray
    }
}
