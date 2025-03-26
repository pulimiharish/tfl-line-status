package com.tfl.linestatus.statuslist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tfl.domain.model.TubeLineStatus
import com.tfl.linestatus.R
import com.tfl.linestatus.utils.getColorForLine
import com.tfl.linestatus.utils.getStatusColor

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LineStatusCard(
    tubeLineStatus: TubeLineStatus,
    selectedItem: (String?, String?, String?) -> Unit
) {
    val onClickTalkback = stringResource(R.string.see_more_details_about, tubeLineStatus.name ?: "")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 6.dp)
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
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(8.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(getColorForLine(tubeLineStatus.name))
            )

            Spacer(modifier = Modifier.width(12.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                maxItemsInEachRow = 2
            ) {
                Text(
                    text = tubeLineStatus.name ?: "Unknown Line",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f, fill = true)
                        .semantics { contentDescription = "Line name ${tubeLineStatus.name}" }
                )

                Text(
                    text = tubeLineStatus.lineStatuses?.get(0)?.statusSeverityDescription ?: "No status",
                    style = MaterialTheme.typography.bodyLarge,
                    color = getStatusColor(tubeLineStatus.lineStatuses?.get(0)?.statusSeverityDescription),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .semantics { contentDescription = "Status ${tubeLineStatus.lineStatuses?.get(0)?.statusSeverityDescription}" }
                )
            }
        }
    }
}
