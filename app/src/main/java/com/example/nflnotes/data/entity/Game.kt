package com.example.nflnotes.data.entity

data class Game(
    val hostName: String,
    val hostScore: String,
    val guestName: String,
    val guestScore: String,
    var isWatched: Boolean = false
)