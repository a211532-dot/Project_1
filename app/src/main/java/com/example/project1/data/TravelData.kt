package com.example.project1.data

// This is the "Blueprint" for your app's data
data class TravelData(
    val destinationName: String = "Home", // Default starting name
    val isTrafficClear: Boolean = true    // Default traffic status
)