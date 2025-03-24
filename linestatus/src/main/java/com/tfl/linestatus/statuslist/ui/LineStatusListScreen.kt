package com.tfl.linestatus.statuslist.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.tfl.linestatus.statuslist.viewmodel.LineStatusViewModel
import com.tfl.linestatus.shared.ui.ErrorView
import com.tfl.linestatus.shared.ui.LoadingView
import com.tfl.linestatus.state.ViewState
import com.tfl.linestatus.R

@Composable
fun LineStatusListScreen(
    viewModel: LineStatusViewModel = hiltViewModel(),
    selectedItem: (String?, String?, String?) -> Unit
) {
    val lineStatusState = viewModel.lineStatusStateFlow.collectAsState().value

    when (lineStatusState) {
        is ViewState.Success -> {
            LineStatusList(
                title = stringResource(R.string.tfl_line_status),
                tubeLineStatuses = lineStatusState.data,
                selectedItem = selectedItem
            )
        }

        is ViewState.Error -> {
            ErrorView(
                reason = lineStatusState.message
            )
        }

        is ViewState.Loading -> {
            LoadingView()
        }

        else -> {}
    }
}

