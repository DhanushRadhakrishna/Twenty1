package com.habits.twenty1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.habits.twenty1.game_logic.Card
import com.habits.twenty1.game_logic.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.habits.twenty1.game_logic.deck
class NormalGameViewModel : ViewModel() {

    private val _gameMessage = MutableStateFlow("Place your bet")
    val gameMessage : StateFlow<String> = _gameMessage

    private val _dealersHand = MutableStateFlow<List<Card>>(emptyList())
    val dealersHand : StateFlow<List<Card>> = _dealersHand

    private val _playersHand = MutableStateFlow<List<Card>>(emptyList())
    val playersHand : StateFlow<List<Card>> = _playersHand


    val playerCards = mutableListOf<Card>()
    val dealerCards = mutableListOf<Card>()
    lateinit var dealersSecondCard : Card
    val game = Game(deck)
    init {
        game.shuffleDeck()
        //player gets one
        playerCards.add(game.dealACard())
        _playersHand.value = playerCards
        dealerCards.add(game.dealACard())
        _dealersHand.value = dealerCards
        playerCards.add(game.dealACard())
        _playersHand.value = playerCards
        dealersSecondCard = game.dealACard()
        dealerCards.add(Card("",'0',0))
        _dealersHand.value = dealerCards
        //if bet is empty for more than 5secs show a toast
        _gameMessage.value = "Hit? Stand? Double Down?"
    }


}