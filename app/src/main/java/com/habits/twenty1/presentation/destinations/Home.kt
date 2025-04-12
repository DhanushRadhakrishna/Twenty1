package com.habits.twenty1.presentation.destinations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habits.twenty1.presentation.ui.theme.Twenty1Theme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.tertiary),
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            Text("Hello!\nand Welcome to TwentyOne",
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(18.dp, top = 64.dp),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Left,
                color = MaterialTheme.colorScheme.tertiary)
            Text("Sharpen your skills, master your\nstrategy, and beat the odds\none hand at a time",
                modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth().padding(18.dp),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Left,
                color = MaterialTheme.colorScheme.secondary)
            Text("No pressure. No money.\nJust practice",
                modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth().padding(18.dp),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Left,
                color = MaterialTheme.colorScheme.secondary,
            )
            Button(onClick = {},
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(18.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
            )
            {
                Text(text = "Start a new game")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Twenty1Theme {
        HomeScreen()
    }
}