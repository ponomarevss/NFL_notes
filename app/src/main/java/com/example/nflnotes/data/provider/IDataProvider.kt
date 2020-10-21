package com.example.nflnotes.data.provider

import androidx.lifecycle.LiveData
import com.example.nflnotes.data.entity.Game

interface IDataProvider {
    fun getGames(): LiveData<List<Game>>
}