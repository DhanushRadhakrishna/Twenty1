package com.habits.twenty1.presentation

interface Destination{
    val route : String
}

object NormalGame : Destination{
    override val route: String
        get() = "NormalGame"
}

object Home : Destination{
    override val route: String
        get() = "HomeScreen"
}