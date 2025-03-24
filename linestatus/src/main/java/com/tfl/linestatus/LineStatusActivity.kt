package com.tfl.linestatus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.tfl.linestatus.navigation.LineStatusNavHost
import com.tfl.linestatus.theme.TFLTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LineStatusActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TFLTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LineStatusNavHost()
                }
            }
        }
    }
}