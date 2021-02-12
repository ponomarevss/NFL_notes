package com.example.nflnotes.mvp.presenter

import com.example.nflnotes.mvp.view.WeekView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class WeekPresenter(val router: Router) :
    MvpPresenter<WeekView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        viewState.init()
    }

    fun backPressed() = router.exit().let { true }

}