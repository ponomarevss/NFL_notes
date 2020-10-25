package com.example.nflnotes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nflnotes.data.entity.Game
import com.example.nflnotes.data.provider.HtmlDataProvider
import com.example.nflnotes.data.provider.IDataProvider

class MainViewModel : ViewModel() {

    private val gamesLiveData : MutableLiveData<List<Game>> = MutableLiveData()
    private val dataProvider: IDataProvider = HtmlDataProvider()

}