package com.tfl.linestatus.statuslist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tfl.domain.model.LineStatus
import com.tfl.domain.model.TubeLineStatus
import com.tfl.linestatus.R
import com.tfl.linestatus.utils.getColorForLine
import com.tfl.linestatus.utils.getStatusColor

@Composable
fun LineStatusCard(
    tubeLineStatus: TubeLineStatus,
    selectedItem: (String?, String?, String?) -> Unit
) {
    val onClickTalkback = stringResource(R.string.see_more_details_about, tubeLineStatus.name ?: "")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .clickable {
                selectedItem(
                    tubeLineStatus.name,
                    tubeLineStatus.lineStatuses?.get(0)?.statusSeverityDescription ?: "STATUS",
                    tubeLineStatus.lineStatuses?.get(0)?.reason ?: "REASON"
                )
            }
            .semantics {
                onClick(
                    label = onClickTalkback,
                    action = null
                )
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(8.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(4.dp))
                    .background(getColorForLine(tubeLineStatus.name))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = tubeLineStatus.name ?: "Unknown Line",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.semantics { contentDescription = "Line name ${tubeLineStatus.name}" }
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = tubeLineStatus.lineStatuses?.get(0)?.statusSeverityDescription ?: "No status",
                    style = MaterialTheme.typography.bodyMedium,
                    color = getStatusColor(tubeLineStatus.lineStatuses?.get(0)?.statusSeverityDescription),
                    fontSize = 14.sp,
                    modifier = Modifier.semantics { contentDescription = "Status ${tubeLineStatus.lineStatuses?.get(0)?.statusSeverityDescription}" }
                )
            }
        }
    }
}
