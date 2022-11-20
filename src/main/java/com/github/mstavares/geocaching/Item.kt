package com.github.mstavares.geocaching

enum class Difficulty {
    VERY_EASY, EASY, MEDIUM, HARD, VERY_HARD
}

class Location(
    val rangeInMeters: Int,
    val latitude: Double,
    val longitude: Double
)

data class Item(
    val description: String,
    val difficulty: Difficulty,
    val location: Location
)