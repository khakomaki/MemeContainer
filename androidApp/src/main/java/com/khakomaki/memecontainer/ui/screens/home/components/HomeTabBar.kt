package com.khakomaki.memecontainer.ui.screens.home.components

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.khakomaki.memecontainer.ui.screens.home.Tab

@Composable
fun HomeTabBar(
    selectedTab: Tab,
    onTabSelected: (Tab) -> Unit
) {
    TabRow(selectedTabIndex = selectedTab.ordinal) {
        Tab.entries.forEach { tab ->
            Tab(
                selected = selectedTab == tab,
                onClick = { onTabSelected(tab) },
                text = { Text(tab.label) }
            )
        }
    }
}
