package com.tfl.linestatus

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.tfl.domain.model.LineStatus
import com.tfl.domain.model.TubeLineStatus
import com.tfl.linestatus.statuslist.ui.LineStatusCard

@Preview(locale = "fr-rFR", showBackground = true, showSystemUi = true)
@Preview(locale = "en-rGB", showBackground = true, showSystemUi = true)
@PreviewScreenSizes
@PreviewFontScale
@Composable
fun LineStatusCardPreview() {
    val tubeLineStatus = TubeLineStatus(
        id = "bakerloo", name = "Bakerloo",
        lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Good Service", reason = ""))
    )

    LineStatusCard(
        tubeLineStatus = tubeLineStatus,
        selectedItem = { _, _, _ -> }
    )
}