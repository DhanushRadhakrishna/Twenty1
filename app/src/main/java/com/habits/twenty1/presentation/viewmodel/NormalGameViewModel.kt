package com.habits.twenty1.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.habits.twenty1.game_logic.Card
import com.habits.twenty1.game_logic.DeckProvider
import com.habits.twenty1.game_logic.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.habits.twenty1.presentation.NormalGameUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NormalGameViewModel  @Inject constructor(): ViewModel() {

//    private val game : Game()
    private val _uiState = MutableStateFlow(NormalGameUiState())
    val uiState : StateFlow<NormalGameUiState> = _uiState.asStateFlow()
    val playerCards = mutableListOf<Card>()
    val dealerCards = mutableListOf<Card>()
    val deckProvider  = DeckProvider()
    val game = Game(deckProvider)


    init{

        game.shuffleDeck()
        dealPlayerHand()
        dealDealerHand()
        dealPlayerHand()
        dealDealerHand()
        checkBlackJack()
        if(game.handValue(playerCards)>9)
        {
            updateActionCenter(null,null,true,null)
        }
        if(game.checkSplit(playerCards))
        {
            updateActionCenter(null,null,null,true)
        }
    }
    fun dealPlayerHand()
    {
        playerCards.add(game.dealACard())
        _uiState.update {
            it.copy(playerHand = playerCards)
        }
    }
    fun dealDealerHand()
    {
        dealerCards.add(game.dealACard())
        _uiState.update {
            it.copy(dealerHand = dealerCards)
        }
    }
    //check if players cards is blackjack
    fun checkBlackJack()
    {
        if(game.isBlackjack(playerCards))
        {
            _uiState.update {
                it.copy(gameMessage = "Blackjack! You Win!")
            }
        }
        else{
            _uiState.update {
                it.copy(gameMessage = "Hit? Stand? Double Down?")
            }
        }
    }
    //player hits
    fun hit() {
        // Draw exactly one card and add it
        val updatedPlayerCards = playerCards.toMutableList().apply {
            add(game.dealACard())
        }

        // Assign the new list back to playerCards
        playerCards.clear()
        playerCards.addAll(updatedPlayerCards)

        // Update the UI state with the new list
        _uiState.update {
            it.copy(playerHand = playerCards.toList()) // Convert to immutable list
        }

        // Update action buttons based on hand size
        if (playerCards.size > 2) {
            updateActionCenter(null, null, false, false)
        }

        // Check for bust
        if (game.handValue(playerCards) > 21) {
            updateActionCenter(false, false, false, false)
            showTheWinner()
        }
    }
    fun stand()
    {
        //turn dealer's card up
        //if dealers hand is less than 17, hit dealer hand
        while(game.handValue(dealerCards)<17)
        {
            dealerCards.add(game.dealACard())
            _uiState.update {
                it.copy(dealerHand = dealerCards)
            }
        }
        //determine the winner
        updateActionCenter(false,false,false,false)
        showTheWinner()
    }
    fun split()
    {

    }
    fun doubleDown()
    {

    }
    fun updateActionCenter(hitState : Boolean?,standState: Boolean?,doubleDownState: Boolean?,splitState: Boolean? )
    {
        _uiState.update {
            it.copy(
                hitActionState = hitState?:it.hitActionState,
                standActionState = standState?:it.standActionState,
                doubleDownActionState = doubleDownState?:it.doubleDownActionState,
                splitActionState = splitState?:it.splitActionState
            )
        }

    }

    fun showTheWinner()
    {
        _uiState.update {
            it.copy(gameMessage = game.determineWinner(playerCards,dealerCards))
        }
    }


}