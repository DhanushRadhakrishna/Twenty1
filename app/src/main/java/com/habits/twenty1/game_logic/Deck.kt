package com.habits.twenty1.game_logic

import javax.inject.Inject

class DeckProvider @Inject constructor() {
    private val deck: MutableList<Card> = mutableListOf(
        Card("hearts", "2", 2), Card("hearts", "3", 3), Card("hearts", "4", 4), Card("hearts", "5", 5),
        Card("hearts", "6", 6), Card("hearts", "7", 7), Card("hearts", "8", 8), Card("hearts", "9", 9),
        Card("hearts", "10", 10),Card("hearts", "jack", 10), Card("hearts", "queen", 10), Card("hearts", "ace", 11),

        Card("diamonds", "2", 2), Card("diamonds", "3", 3), Card("diamonds", "4", 4), Card("diamonds", "5", 5),
        Card("diamonds", "6", 6), Card("diamonds", "7", 7), Card("diamonds", "8", 8), Card("diamonds", "9", 9),
        Card("diamonds", "10", 10), Card("diamonds", "queen", 10), Card("diamonds", "king", 10), Card("diamonds", "ace", 11),

        Card("clubs", "2", 2), Card("clubs", "3", 3), Card("clubs", "4", 4), Card("clubs", "5", 5),
        Card("clubs", "6", 6), Card("clubs", "7", 7), Card("clubs", "8", 8), Card("clubs", "9", 9),
        Card("clubs", "10", 10), Card("clubs", "queen", 10), Card("clubs", "king", 10), Card("clubs", "ace", 11),

        Card("spades", "2", 2), Card("spades", "3", 3), Card("spades", "4", 4), Card("spades", "5", 5),
        Card("spades", "6", 6), Card("spades", "7", 7), Card("spades", "8", 8), Card("spades", "9", 9),
        Card("spades", "10", 10), Card("spades", "ace", 11)
    )

    fun provideDecks(numberOfDecks : Int =1) : MutableList<Card>
    {
        return deck
    }
}
//, Card("hearts", "jack", 10)
//, Card("hearts", "king", 10)
//, Card("diamonds", "jack", 10)
//, Card("spades", "jack", 10)
//, Card("clubs", "jack", 10)
//, Card("spades", "queen", 10)
//, Card("spades", "king", 10)