package com.khakomaki.memecontainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.khakomaki.memecontainer.ui.MemeContainer
import com.khakomaki.memecontainer.ui.theme.MemeContainerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MemeContainerTheme {
                MemeContainer()
            }
        }
    }
}
