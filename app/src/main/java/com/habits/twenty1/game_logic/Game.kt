package com.habits.twenty1.game_logic

class Game(val deck : MutableList<Card>) {

    fun shuffleDeck()
    {
        deck.shuffle()
    }

    fun dealACard() : Card
    {
        return deck.removeAt(0)
    }
    //returns the value of the hand accounting the number of ace
    fun handValue(hand : List<Card>) : Int
    {

        var totalValue = 0
        var ace_count = 0
        for (card in hand)
        {
            totalValue += card.value
            if(card.rank == 'A')
            {
                ace_count++
            }
        }
        while (totalValue > 21 && ace_count>0)
        {
            totalValue -=10
            ace_count -=1
        }
        return totalValue
    }
    //function to check if the hand is a blackjack
    fun isBlackjack(hand : List<Card>): Boolean
    {
        return handValue(hand) == 21 && hand.size == 2
    }
    //check if hand can split
    fun checkSplit(hand : List<Card>):Boolean
    {
        if(hand.size>2)
        {
            return false
        }
        else{
            if(hand[0].rank==hand[1].rank)
            {
                return true
            }
        }
        return false
    }

    fun determineWinner(playerHand : List<Card>, dealerHand : List<Card>) : String
    {
        val dealerHandValue = handValue(dealerHand)
        val playerHandValue = handValue(playerHand)
        val result : String
        if(playerHandValue>21)
        {
            result = "bust"
        }
        else if(dealerHandValue>21 || playerHandValue>dealerHandValue)
        {
            result = "win"
        }
        else if(playerHandValue < dealerHandValue)
        {
            result = "lose"
        }
        else{
            result = "push"
        }
        return result
    }

    fun shouldReshuffle(deck : List<Card>): Boolean
    {
        return deck.size < 20
    }



}