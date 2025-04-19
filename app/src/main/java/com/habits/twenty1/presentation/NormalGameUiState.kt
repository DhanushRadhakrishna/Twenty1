package com.habits.twenty1.presentation

import com.habits.twenty1.game_logic.Card

data class NormalGameUiState(
    val dealerHand : List<Card> = emptyList(),
    val playerHand : List<Card> = emptyList(),
    val gameMessage : String = "Place your bet",
    val hitActionState : Boolean = true,
    val standActionState : Boolean = true,
    val doubleDownActionState : Boolean = false,
    val splitActionState : Boolean = false

    )