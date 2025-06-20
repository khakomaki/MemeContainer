package com.khakomaki.memecontainer.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khakomaki.memecontainer.ui.navigation.MemeContainerNavHost

@Composable
fun MemeContainer() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MemeContainerNavHost()
    }
}
