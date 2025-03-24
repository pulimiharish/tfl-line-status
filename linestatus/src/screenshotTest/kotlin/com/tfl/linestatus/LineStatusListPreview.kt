package com.tfl.linestatus

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.tfl.domain.model.LineStatus
import com.tfl.domain.model.TubeLineStatus
import com.tfl.linestatus.statuslist.ui.LineStatusList

@Preview(showBackground = true, showSystemUi = true)
@PreviewScreenSizes
@PreviewFontScale
@Composable
fun LineStatusListPreview() {
    val sampleStatuses = listOf(
        TubeLineStatus(
            id = "bakerloo", name = "Bakerloo",
            lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Good Service", reason = ""))
        ),
        TubeLineStatus(
            id = "central", name = "Central",
            lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Minor Delays", reason = "Minor delays between White City and Ealing Broadway/West Ruislip."))
        ),
        TubeLineStatus(
            id = "circle", name = "Circle",
            lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Good Service", reason = ""))
        ),
        TubeLineStatus(
            id = "district", name = "District",
            lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Minor Delays", reason = "Minor delays between Upminster and Barking."))
        ),
        TubeLineStatus(
            id = "hammersmith-city", name = "Hammersmith & City",
            lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Good Service", reason = ""))
        ),
        TubeLineStatus(
            id = "jubilee", name = "Jubilee",
            lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Minor Delays", reason = "Minor delays due to an earlier faulty train at London Bridge."))
        ),
        TubeLineStatus(
            id = "metropolitan", name = "Metropolitan",
            lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Minor Delays", reason = "Minor delays between Uxbridge and Aldgate."))
        ),
        TubeLineStatus(
            id = "northern", name = "Northern",
            lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Minor Delays", reason = "Minor delays between Camden Town and Edgware."))
        ),
        TubeLineStatus(
            id = "piccadilly", name = "Piccadilly",
            lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Severe Delays", reason = "Severe delays due to planned engineering work and signal failure."))
        ),
        TubeLineStatus(
            id = "victoria", name = "Victoria",
            lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Good Service", reason = ""))
        ),
        TubeLineStatus(
            id = "waterloo-city", name = "Waterloo & City",
            lineStatuses = listOf(LineStatus(id = 0, statusSeverityDescription = "Planned Closure", reason = "Service operates weekdays only."))
        )
    )

    LineStatusList(
        title = stringResource(R.string.tfl_line_status),
        tubeLineStatuses = sampleStatuses,
        selectedItem = { _, _, _ -> }
    )
}