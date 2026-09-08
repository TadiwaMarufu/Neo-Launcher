package com.neoapps.neolauncher.compose.pages.preferences

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.neoapps.neolauncher.compose.components.ComposeSwitchView
import com.neoapps.neolauncher.compose.components.ViewWithActionBar
import com.neoapps.neolauncher.nowbrief.NowBriefContent
import com.neoapps.neolauncher.widgets.MaterialYouClockContent
import com.neoapps.neolauncher.widgets.MaterialYouQuoteContent
import com.neoapps.neolauncher.widgets.MaterialYouSearchBarContent
import com.neoapps.neolauncher.widgets.MaterialYouWeatherContent

@Composable
fun NowBriefPrefsPage() {
    var showNowBrief by remember { mutableStateOf(true) }
    var showClockWidget by remember { mutableStateOf(true) }
    var showWeatherWidget by remember { mutableStateOf(true) }
    var showQuoteWidget by remember { mutableStateOf(true) }
    var showSearchBarWidget by remember { mutableStateOf(true) }

    ViewWithActionBar(
        title = "Now Brief & Custom Widgets"
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Now Brief Bar",
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium
                )
                ComposeSwitchView(
                    title = "Enable Now Brief Bar",
                    summary = "Show Samsung-style Now Briefing bar at the bottom",
                    isChecked = showNowBrief,
                    index = 0,
                    groupSize = 1,
                    onChange = { showNowBrief = it }
                )
                if (showNowBrief) {
                    NowBriefContent(
                        modifier = Modifier.padding(top = 8.dp),
                        isVisible = true
                    )
                }
            }

            item {
                Text(
                    text = "Material You Widgets Preview",
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium
                )
            }

            item {
                ComposeSwitchView(
                    title = "Material You Clock Widget",
                    summary = "Stacked digital 12/24 clock card",
                    isChecked = showClockWidget,
                    index = 0,
                    groupSize = 4,
                    onChange = { showClockWidget = it }
                )
                if (showClockWidget) {
                    MaterialYouClockContent(modifier = Modifier.padding(top = 8.dp))
                }
            }

            item {
                ComposeSwitchView(
                    title = "Material You Weather Widget",
                    summary = "Humidity, dew point and weather card",
                    isChecked = showWeatherWidget,
                    index = 1,
                    groupSize = 4,
                    onChange = { showWeatherWidget = it }
                )
                if (showWeatherWidget) {
                    MaterialYouWeatherContent(modifier = Modifier.padding(top = 8.dp))
                }
            }

            item {
                ComposeSwitchView(
                    title = "Material You Quote Widget",
                    summary = "Daily quote & inspiration card",
                    isChecked = showQuoteWidget,
                    index = 2,
                    groupSize = 4,
                    onChange = { showQuoteWidget = it }
                )
                if (showQuoteWidget) {
                    MaterialYouQuoteContent(modifier = Modifier.padding(top = 8.dp))
                }
            }

            item {
                ComposeSwitchView(
                    title = "Material You Search Bar Widget",
                    summary = "Custom rounded Material You search bar",
                    isChecked = showSearchBarWidget,
                    index = 3,
                    groupSize = 4,
                    onChange = { showSearchBarWidget = it }
                )
                if (showSearchBarWidget) {
                    MaterialYouSearchBarContent(modifier = Modifier.padding(top = 8.dp))
                }
            }
        }
    }
}
