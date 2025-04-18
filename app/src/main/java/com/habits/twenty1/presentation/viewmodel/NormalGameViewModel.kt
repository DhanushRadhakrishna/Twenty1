package com.habits.twenty1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.habits.twenty1.game_logic.Card
import com.habits.twenty1.game_logic.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.habits.twenty1.game_logic.deck
import com.habits.twenty1.presentation.NormalGameUiState
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NormalGameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(NormalGameUiState())
    val uiState : StateFlow<NormalGameUiState> = _uiState.asStateFlow()

    val playerCards = mutableListOf<Card>()
    val dealerCards = mutableListOf<Card>()
    val game = Game(deck)

    init{

        game.shuffleDeck()
        dealPlayerHand()
        dealDealerHand()
        dealPlayerHand()
        dealDealerHand()
        checkBlackJack()
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
    fun hit()
    {
        playerCards.add(game.dealACard())
        _uiState.update {
            it.copy(playerHand = playerCards)
        }
        updateActionCenter()
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
//        updateActionCenter()
        showTheWinner()
    }
    //if players busts
    fun updateActionCenter()
    {
        val playerHandValue = game.handValue(playerCards)
        //if player bust
        if(playerHandValue>21)
        {
            _uiState.update {
                it.copy(hitActionState = false,
                    doubleDownActionState = false,
                    splitActionState = false,
                    standActionState = false
                )
            }
        }
        //if player can hit, split, stand, double
        else
        {
            _uiState.update {
                it.copy(hitActionState = true,
                    standActionState = true,
                    splitActionState = false,
                    doubleDownActionState = false)
            }
            //if player can split
            if(game.checkSplit(playerCards))
            {
                _uiState.update {
                    it.copy(splitActionState = true)
                }
            }
            //if player can double
            if(game.handValue(playerCards)>9)
            {
                _uiState.update {
                    it.copy(doubleDownActionState = true)
                }
            }
        }
    }

    fun showTheWinner()
    {
        _uiState.update {
            it.copy(gameMessage = game.determineWinner(playerCards,dealerCards))
        }
    }

}