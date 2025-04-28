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
import java.lang.Thread.State
import javax.inject.Inject

@HiltViewModel
class NormalGameViewModel  @Inject constructor(val game : Game): ViewModel() {


    private val _uiState = MutableStateFlow(NormalGameUiState())
    val uiState : StateFlow<NormalGameUiState> = _uiState.asStateFlow()

    private val _playerHand = MutableStateFlow<List<List<Card>>>(listOf())
    val playerHand : StateFlow<List<List<Card>>> = _playerHand.asStateFlow()

    private val _dealerHand = MutableStateFlow<List<Card>>(listOf())
    val dealerHand : StateFlow<List<Card>> = _dealerHand.asStateFlow()

//    val playerCards = mutableListOf<Card>()
    val dealerCards = mutableListOf<Card>()
    val playerHands : MutableList<MutableList<Card>> = mutableListOf(mutableListOf<Card>())

    init{
        game.shuffleDeck()
        dealPlayerHand()
        dealDealerHand()
        dealPlayerHand()
        dealDealerHand()
        checkBlackJack(playerHands[0])
        if(game.handValue(playerHands[0])>9)
        {
            updateActionCenter(null,null,true,null)
        }
        if(game.checkSplit(playerHands[0]))
        {
            updateActionCenter(null,null,null,true)
        }
    }
    private fun dealPlayerHand(index : Int =0)
    {
        val newHand = playerHands[index]
        newHand.add(game.dealACard())
        playerHands[index] = newHand
        updatePlayerStateFlow()
    }
    private fun updatePlayerStateFlow()
    {
        _playerHand.value = playerHands.map{it.toList()}
    }

    private fun dealDealerHand()
    {
        dealerCards.add(game.dealACard())

        _dealerHand.value = dealerCards.map { it.copy() }
    }
    //check if players cards is blackjack
    private fun checkBlackJack(hand : List<Card>)
    {
        if(game.isBlackjack(hand))
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
        dealPlayerHand()

        // Update action buttons based on hand size
        if (playerHands[0].size > 2) {
            updateActionCenter(null, null, false, false)
        }

        // Check for bust
        if (game.handValue(playerHands[0]) > 21) {
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
            dealDealerHand()
        }
        //determine the winner
        updateActionCenter(false,false,false,false)
        showTheWinner()
    }
    fun split()
    {
        //change the playerCards and change the PlayerHands
        playerHands.add(mutableListOf(playerHands[0].removeAt(1)))
        //use above to change the _playerHand
        updatePlayerStateFlow()
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
            it.copy(gameMessage = game.determineWinner(playerHands[0],dealerCards))
        }
    }

}