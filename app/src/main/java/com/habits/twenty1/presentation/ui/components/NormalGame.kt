package com.habits.twenty1.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habits.twenty1.presentation.ui.theme.OffWhite

@Composable
fun NormalGame(modifier : Modifier = Modifier.padding(top = 24.dp))
{
        Text(
            text = "Normal Game",
            modifier = modifier.fillMaxWidth().padding(16.dp),
            textAlign = TextAlign.Center,
        )


}
@Composable
fun Table(modifier: Modifier)
{
    Row(modifier = modifier.padding(12.dp).background(color = OffWhite)) {

    }
}
@Composable
fun DealersCards(modifier: Modifier){
}
@Preview
@Composable
fun NormalGameScreen()
{
    NormalGame()
}