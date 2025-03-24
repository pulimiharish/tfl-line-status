package com.tfl.linestatus.statuslist.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tfl.domain.model.TubeLineStatus
import com.tfl.domain.shared.Result
import com.tfl.domain.usecase.LineStatusUseCase
import com.tfl.linestatus.state.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class LineStatusViewModel @Inject constructor(
    private val lineStatusUseCase: LineStatusUseCase
) : ViewModel() {

    private val _lineStatusStateFlow: MutableStateFlow<ViewState<List<TubeLineStatus>>> =
        MutableStateFlow(ViewState.Idle)
    open val lineStatusStateFlow = _lineStatusStateFlow.asStateFlow()
    private val statusOrder = listOf("Good Service", "Minor Delays", "Severe Delays")

    init {
        getTubeLineStatusList()
    }

    private fun sortLines(lines: List<TubeLineStatus>): List<TubeLineStatus> {
        return lines.sortedWith(
            compareBy<TubeLineStatus> {
                statusOrder.indexOf(it.lineStatuses?.get(0)?.statusSeverityDescription).let { index ->
                    if (index == -1) statusOrder.size else index
                }
            }.thenBy { it.name }
        )
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun getTubeLineStatusList() {
         viewModelScope.launch {
             lineStatusUseCase().collect {
                when (it) {
                    is Result.Error -> {
                        _lineStatusStateFlow.value = ViewState.Error(it.throwable.message ?: "error loading")
                    }

                    is Result.Success -> {
                        _lineStatusStateFlow.value = ViewState.Success(sortLines(it.data))
                    }
                }
            }
        }
    }
}