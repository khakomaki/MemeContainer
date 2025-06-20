package com.khakomaki.memecontainer.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khakomaki.memecontainer.ui.memes.AddMemeFAB
import com.khakomaki.memecontainer.ui.screens.home.components.HomeTabBar
import com.khakomaki.memecontainer.ui.screens.home.components.HomeTabContent
import com.khakomaki.memecontainer.ui.screens.home.components.HomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onMemeClick: (String) -> Unit,
    onAddMemeClick: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(Tab.Folders) }

    Scaffold(
        topBar = { HomeTopBar() },
        floatingActionButton = { AddMemeFAB(onAddMemeClick) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            HomeTabBar(selectedTab, onTabSelected = { selectedTab = it } )

            Spacer(modifier = Modifier.padding(8.dp))

            HomeTabContent(
                selectedTab = selectedTab,
                onMemeClick = onMemeClick,
                onFolderClick = {}
            )
        }
    }
}
