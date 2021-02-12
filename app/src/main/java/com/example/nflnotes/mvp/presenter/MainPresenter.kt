package com.example.nflnotes.mvp.presenter

import com.example.nflnotes.mvp.view.MainView
import com.example.nflnotes.navigation.Screens
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class MainPresenter(val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.GamesScreen())
    }

    fun backPressed() = router.exit()

}