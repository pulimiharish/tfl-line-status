package com.tfl.linestatus.utils

import androidx.compose.ui.graphics.Color
import com.tfl.linestatus.theme.BakerlooColor
import com.tfl.linestatus.theme.CentralColor
import com.tfl.linestatus.theme.CircleColor
import com.tfl.linestatus.theme.DistrictColor
import com.tfl.linestatus.theme.GoodServiceColor
import com.tfl.linestatus.theme.HammersmithAndCityColor
import com.tfl.linestatus.theme.JubileeColor
import com.tfl.linestatus.theme.MetropolitanColor
import com.tfl.linestatus.theme.MinorDelaysColor
import com.tfl.linestatus.theme.NorthernColor
import com.tfl.linestatus.theme.PartClosureColor
import com.tfl.linestatus.theme.PiccadillyColor
import com.tfl.linestatus.theme.PlannedClosureColor
import com.tfl.linestatus.theme.SevereDelaysColor
import com.tfl.linestatus.theme.VictoriaColor
import com.tfl.linestatus.theme.WaterlooAndCityColor

fun getColorForLine(lineName: String?): Color {
    return when (lineName) {
        "Bakerloo" -> BakerlooColor
        "Central" -> CentralColor
        "Circle" -> CircleColor
        "District" -> DistrictColor
        "Hammersmith & City" -> HammersmithAndCityColor
        "Jubilee" -> JubileeColor
        "Metropolitan" -> MetropolitanColor
        "Northern" -> NorthernColor
        "Piccadilly" -> PiccadillyColor
        "Victoria" -> VictoriaColor
        "Waterloo & City" -> WaterlooAndCityColor
        else -> Color.Gray
    }
}

fun getStatusColor(status: String?): Color {
    return when (status) {
        "Good Service" -> GoodServiceColor
        "Minor Delays" -> MinorDelaysColor
        "Severe Delays" -> SevereDelaysColor
        "Part Closure" -> PartClosureColor
        "Planned Closure" -> PlannedClosureColor
        else -> Color.Gray
    }
}
