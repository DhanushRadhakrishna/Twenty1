package com.habits.twenty1.presentation.ui.components

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habits.twenty1.presentation.Destination
import com.habits.twenty1.presentation.Home
import com.habits.twenty1.presentation.NormalGame
import com.habits.twenty1.presentation.ui.theme.Twenty1Theme


@Composable
fun Home(modifier: Modifier  = Modifier)
{
    Twenty1Theme {
        val navController = rememberNavController()
        Surface(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.tertiary)) {
            NavHost(navController = navController, startDestination = Home.route)
            {
                composable(route = Home.route){ HomeScreen() }
                composable(route = NormalGame.route){}
            }
        }
    }

}
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Twenty1Theme {
        HomeScreen()
    }
}