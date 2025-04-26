package com.habits.twenty1.presentation.ui.utilities

import com.habits.twenty1.R

enum class CardImageEnum(val cardName : String,val resId  : Int) {
        CLUBS_2("clubs_2", R.drawable.clubs_2),
        CLUBS_3("clubs_3", R.drawable.clubs_3),
        CLUBS_4("clubs_4", R.drawable.clubs_4),
        CLUBS_5("clubs_5", R.drawable.clubs_5),
        CLUBS_6("clubs_6", R.drawable.clubs_6),
        CLUBS_7("clubs_7", R.drawable.clubs_7),
        CLUBS_8("clubs_8", R.drawable.clubs_8),
        CLUBS_9("clubs_9", R.drawable.clubs_9),
        CLUBS_10("clubs_10", R.drawable.clubs_10),
        CLUBS_JACK("clubs_jack", R.drawable.clubs_jack),
        CLUBS_QUEEN("clubs_queen", R.drawable.clubs_queen),
        CLUBS_KING("clubs_king", R.drawable.clubs_king),
        CLUBS_ACE("clubs_ace", R.drawable.clubs_ace),

        DIAMONDS_2("diamonds_2", R.drawable.diamonds_2),
        DIAMONDS_3("diamonds_3", R.drawable.diamonds_3),
        DIAMONDS_4("diamonds_4", R.drawable.diamonds_4),
        DIAMONDS_5("diamonds_5", R.drawable.diamonds_5),
        DIAMONDS_6("diamonds_6", R.drawable.diamonds_6),
        DIAMONDS_7("diamonds_7", R.drawable.diamonds_7),
        DIAMONDS_8("diamonds_8", R.drawable.diamonds_8),
        DIAMONDS_9("diamonds_9", R.drawable.diamonds_9),
        DIAMONDS_10("diamonds_10", R.drawable.diamonds_10),
        DIAMONDS_JACK("diamonds_jack", R.drawable.diamonds_jack),
        DIAMONDS_QUEEN("diamonds_queen", R.drawable.diamonds_queen),
        DIAMONDS_KING("diamonds_king", R.drawable.diamonds_king),
        DIAMONDS_ACE("diamonds_ace", R.drawable.diamonds_ace),

        HEARTS_2("hearts_2", R.drawable.hearts_2),
        HEARTS_3("hearts_3", R.drawable.hearts_3),
        HEARTS_4("hearts_4", R.drawable.hearts_4),
        HEARTS_5("hearts_5", R.drawable.hearts_5),
        HEARTS_6("hearts_6", R.drawable.hearts_6),
        HEARTS_7("hearts_7", R.drawable.hearts_7),
        HEARTS_8("hearts_8", R.drawable.hearts_8),
        HEARTS_9("hearts_9", R.drawable.hearts_9),
        HEARTS_10("hearts_10", R.drawable.hearts_10),
        HEARTS_JACK("hearts_jack", R.drawable.hearts_jack),
        HEARTS_QUEEN("hearts_queen", R.drawable.hearts_queen),
        HEARTS_KING("hearts_king", R.drawable.hearts_king),
        HEARTS_ACE("hearts_ace", R.drawable.hearts_ace),

        SPADES_2("spades_2", R.drawable.spades_2),
        SPADES_3("spades_3", R.drawable.spades_3),
        SPADES_4("spades_4", R.drawable.spades_4),
        SPADES_5("spades_5", R.drawable.spades_5),
        SPADES_6("spades_6", R.drawable.spades_6),
        SPADES_7("spades_7", R.drawable.spades_7),
        SPADES_8("spades_8", R.drawable.spades_8),
        SPADES_9("spades_9", R.drawable.spades_9),
        SPADES_10("spades_10", R.drawable.spades_10),
        SPADES_JACK("spades_jack", R.drawable.spades_jack),
        SPADES_QUEEN("spades_queen", R.drawable.spades_queen),
        SPADES_KING("spades_king", R.drawable.spades_king),
        SPADES_ACE("spades_ace", R.drawable.spades_ace);

        companion object{
            fun fromName(name : String) : CardImageEnum? {
                return entries.find { it.cardName == name }
            }
        }
}