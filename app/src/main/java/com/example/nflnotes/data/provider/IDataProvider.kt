package com.example.nflnotes.data.provider

import com.example.nflnotes.data.entity.Game

interface IDataProvider {
    fun getGames(url : String): List<Game>
}