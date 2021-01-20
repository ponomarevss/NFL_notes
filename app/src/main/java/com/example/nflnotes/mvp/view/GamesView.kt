package com.example.nflnotes.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface GamesView : MvpView {
    fun init()
    fun updateList()
}