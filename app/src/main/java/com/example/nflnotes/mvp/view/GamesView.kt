package com.example.nflnotes.mvp.view

import moxy.MvpView

interface GamesView : MvpView {
    fun init()
    fun updateList()
}