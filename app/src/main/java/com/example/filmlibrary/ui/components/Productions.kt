package com.example.filmlibrary.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmlibrary.data.Production

@Composable
fun ProductionLayout(production: Production, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(350.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(Color(0xFF4A148C)),
        Alignment.Center
    ) {
        Text(
            text = production.title.uppercase(),
            color = Color(0xFFefe5fd),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun AddButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(100.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(Color(0xFF4A148C)),
        Alignment.Center
    ){
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add",
            modifier = Modifier.size(64.dp),
            tint = Color(0xFFefe5fd)
        )
    }
}

@Composable
fun ProductionList(productions: List<Production>, modifier: Modifier = Modifier) {
    LazyColumn {
        itemsIndexed(productions) { index, item ->
            ProductionLayout(
                production = item,
                Modifier
                    .padding(vertical = 8.dp)
            )
        }
        item{
            AddButton(
                modifier
                    .padding(vertical = 8.dp)
            )
        }
    }
}