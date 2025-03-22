package com.example.filmlibrary.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmlibrary.R
import com.example.filmlibrary.data.Genre
import com.example.filmlibrary.data.Movie
import com.example.filmlibrary.data.Production
import com.example.filmlibrary.data.Series
import java.time.LocalDate


@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(125.dp)
            .background(Color(0xFF4A148C)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            color = Color(0xFFeee6ff),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}
