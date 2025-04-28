package com.habits.twenty1.presentation.ui.components

import CardFace
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.habits.twenty1.R
import com.habits.twenty1.game_logic.Card
import com.habits.twenty1.game_logic.DeckProvider
import com.habits.twenty1.presentation.ui.theme.OffWhite
import com.habits.twenty1.presentation.ui.utilities.CardImageEnum
import com.habits.twenty1.presentation.viewmodel.NormalGameViewModel


@Composable
fun NormalGame(viewModel : NormalGameViewModel, modifier: Modifier = Modifier.padding(top = 24.dp)) {


    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val playerHand by viewModel.playerHand.collectAsStateWithLifecycle()
    val dealerHand by viewModel.dealerHand.collectAsStateWithLifecycle()


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

            Table(dealersHand = dealerHand,
                playersHand = playerHand,
                gameMessage = uiState.value.gameMessage,
                modifier = Modifier.weight(0.75f)
            )

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
          playersHand: List<List<Card>>,
          gameMessage : String = "Default message",
          modifier: Modifier = Modifier.fillMaxHeight())
{
    Log.d("NormalGame","Playerhand hash code ${playersHand.hashCode()}")
    Log.d("NormalGame","Game message hash code ${gameMessage.hashCode()}")
    Column(modifier = modifier.background(color = OffWhite)) {
        Row(Modifier.padding(12.dp)) {
            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 12.dp, end = 12.dp)) {
                items(dealersHand) { item ->
                    DealersHand(item)
                }
            }
        }

        Text(text = gameMessage,
            modifier = Modifier.fillMaxWidth().padding(24.dp), color = Color.Black,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
            )
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(12.dp)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LazyColumn() {
                items(items = playersHand)
                {
                    hand -> LazyRow(modifier = Modifier.fillMaxWidth().height(100.dp).padding(start = 12.dp, end = 12.dp, bottom = 4.dp))
                    {
                        items(items = hand) { item ->
                        PlayersHand(item)
                        }
                    }
                }
            }

        }

    }
}

@Composable
fun DealersHand(card: Card, modifier: Modifier = Modifier) {
    val cardDrawableFileName = card.suit +"_"+ card.rank
    val cardResID = CardImageEnum.fromName(cardDrawableFileName)
    Log.d("CardFace:Dealers","${cardDrawableFileName}")
    CardFace(cardResID?.resId ?: R.drawable.blank_card,modifier = Modifier)

}
@Composable
fun PlayersHand(card:Card,modifier: Modifier = Modifier)
{

    val cardDrawableFileName = card.suit +"_"+ card.rank
    val cardResID = CardImageEnum.fromName(cardDrawableFileName)
    Log.d("CardFace:Players","${cardDrawableFileName}")
    CardFace(cardResID?.resId ?: R.drawable.blank_card,modifier = Modifier)

}
//@Preview
@Composable
fun NormalGameScreen() {
//    NormalGame()
}
@Preview
@Composable
fun TablePreview() {
    val previewCards = listOf<Card>( Card("Hearts", "2", 2), Card("Hearts", "3", 3), Card("Hearts", "4", 4), Card("Hearts", "5", 5),
        Card("Hearts", "6", 6))
    val hand1 = listOf(
        Card("hearts", "5", 5),
        Card("hearts", "K", 10)
    )

    val hand2 = listOf(
        Card("spades", "A", 11),
        Card("spades", "9", 9)
    )

    val playerHandsPreview: List<List<Card>> = listOf(hand1, hand2)
    Table(previewCards,playerHandsPreview,"Default message",modifier = Modifier)
}
//@Preview
@Composable
fun DealersCardsPreview() {
    DealersHand(Card("Diamonds", "A",11), modifier = Modifier)
}
@Preview
@Composable
fun NormalGamePreview() {
//    NormalGame()
}
