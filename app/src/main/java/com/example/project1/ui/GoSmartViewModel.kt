package com.example.project1.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.project1.data.TravelData

class GoSmartViewModel : ViewModel() {


    private val _uiState = MutableStateFlow(TravelData())


    val uiState: StateFlow<TravelData> = _uiState.asStateFlow()


    // 1. Updates the name when searching
    fun updateDestination(newDestination: String) {
        _uiState.update { it.copy(destinationName = newDestination) }
    }

    // 2. Updates the traffic status when toggling switches
    fun updateTrafficStatus(isClear: Boolean) {
        _uiState.update { it.copy(isTrafficClear = isClear) }
    }
}