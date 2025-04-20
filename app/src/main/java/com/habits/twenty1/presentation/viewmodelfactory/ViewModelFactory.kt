package com.habits.twenty1.presentation.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.habits.twenty1.game_logic.Game
import com.habits.twenty1.presentation.viewmodel.NormalGameViewModel

class ViewModelFactory(private val game : Game) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NormalGameViewModel::class.java))
        {
            return NormalGameViewModel(game) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}