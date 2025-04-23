package com.habits.twenty1.presentation.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.habits.twenty1.game_logic.Card
import com.habits.twenty1.presentation.ui.theme.OffWhite
import com.habits.twenty1.presentation.viewmodel.NormalGameViewModel


@Composable
fun NormalGame(viewModel : NormalGameViewModel, modifier: Modifier = Modifier.padding(top = 24.dp)) {


    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val playerHand by viewModel.playerHand.collectAsStateWithLifecycle()
    val dealerHand by viewModel.dealerHand.collectAsStateWithLifecycle()
//    LaunchedEffect(uiState.value.playerHand) {
//        Log.d("NormalGame","${uiState.value.playerHand.hashCode()}")
//    }
    Column(modifier = Modifier.padding(12.dp).fillMaxSize()) {
        Text(
            text = "Normal Game",
            modifier = modifier
                .fillMaxWidth()
                .weight(0.05f)
                .wrapContentHeight()
                .padding(10.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
        )

//        key(uiState.value.dealerHand.hashCode(),uiState.value.playerHand.hashCode()) {
            Table(dealersHand = dealerHand,
                playersHand = playerHand,
                gameMessage = uiState.value.gameMessage,
                modifier = Modifier.weight(0.75f)
            )
//        }

        ActionCenter(modifier = Modifier.weight(0.15f),
                    hitButtonState = uiState.value.hitActionState,
                    standButtonState = uiState.value.standActionState,
                    doubleDownButtonState = uiState.value.doubleDownActionState,
                    splitButtonState = uiState.value.splitActionState,
                    onHit = {viewModel.hit()},
                    onStand ={ viewModel.stand()},
                    onSplit = {viewModel.split()},
                    onDoubleDown = {viewModel.doubleDown()}
            )
    }
}

@Composable
fun Table(dealersHand: List<Card>,
          playersHand: List<Card>,
          gameMessage : String = "Default message",
          modifier: Modifier = Modifier.fillMaxHeight().padding(4.dp))
{
    Log.d("NormalGame","Playerhand hash code ${playersHand.hashCode()}")
    Log.d("NormalGame","Game message hash code ${gameMessage.hashCode()}")
    Column(modifier = modifier.background(color = OffWhite)) {
        Text("Dealer", modifier = Modifier.padding(start = 12.dp, top = 12.dp))
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(start = 12.dp, end = 12.dp)) {
            items(dealersHand) { item ->
                 DealersHand(item)
            }
        }
        Text(text = gameMessage,
            modifier = Modifier.fillMaxWidth().padding(24.dp), color = Color.Black,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
            )

        Text("Player", modifier = Modifier.padding(start = 12.dp, top = 16.dp))
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(start = 12.dp, end = 12.dp)) {
            items(items = playersHand, key = { card -> card.hashCode()}) { item ->
                PlayersHand(item)
            }
        }
    }
}

@Composable
fun DealersHand(card: Card, modifier: Modifier = Modifier) {
    var textForCard = ""
    when(card.suit){
        "Diamonds" ->{
            textForCard = card.rank + "♦"
        }
        "Hearts" -> {
            textForCard = card.rank +"♥"
        }
        "Clubs"->{
            textForCard = card.rank + "♣"
        }
        "Spades"->{
            textForCard = card.rank + "♠"
        }
    }
    Text(
        text = textForCard,
        modifier = Modifier.border(width = 2.dp, color = Color.Black).padding(4.dp),
        color = Color.Black,
        style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp)
    )
}
@Composable
fun PlayersHand(card:Card,modifier: Modifier = Modifier)
{
    var textForCard = ""
    when(card.suit){
        "Diamonds" ->{
            textForCard = card.rank + "♦"
        }
        "Hearts" -> {
            textForCard = card.rank +"♥"
        }
        "Clubs"->{
            textForCard = card.rank + "♣"
        }
        "Spades"->{
            textForCard = card.rank + "♠"
        }
    }
    Text(
        text = textForCard,
        modifier = Modifier.border(width = 2.dp, color = Color.Black).padding(4.dp),
        color = Color.Black,
        style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp)
    )
}
//@Preview
@Composable
fun NormalGameScreen() {
//    NormalGame()
}
//@Preview
@Composable
fun TablePreview() {
//    Table(exampleCards, exampleCards,"Default message",modifier = Modifier)
}
//@Preview
@Composable
fun DealersCardsPreview() {
    DealersHand(Card("Diamonds", 'A',11), modifier = Modifier)
}
@Preview
@Composable
fun NormalGamePreview() {
//    NormalGame()
}
