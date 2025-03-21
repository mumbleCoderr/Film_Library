package com.example.filmlibrary.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.filmlibrary.data.Genre
import com.example.filmlibrary.data.Series
import com.example.filmlibrary.ui.theme.FilmLibraryTheme
import java.time.LocalDate


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val p1 = Series(
        title = "THE VIKINGS",
        genre = Genre.ACTION,
        releaseDate = LocalDate.of(2020, 10, 10),
        parts = mapOf(1 to 20, 2 to 15, 3 to 25)
    )

    Text(
        p1.toString()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FilmLibraryTheme {
        Greeting("Android")
    }
}