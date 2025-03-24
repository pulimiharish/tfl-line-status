package com.tfl.linestatus.shared.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.tfl.linestatus.R

@Composable
fun ErrorView(reason: String, modifier: Modifier = Modifier) {
    Text(text = stringResource(R.string.unable_to_load_reason, reason), modifier = modifier.fillMaxSize())
}