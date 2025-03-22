package com.example.filmlibrary.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.filmlibrary.R
import com.example.filmlibrary.data.Production
import com.example.filmlibrary.data.getProductions
import com.example.filmlibrary.ui.components.ProductionList
import com.example.filmlibrary.ui.components.TopBar

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFefe5fd)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        ProductionList(
            getProductions(),
            Modifier
                .weight(1f)
        )
    }
}