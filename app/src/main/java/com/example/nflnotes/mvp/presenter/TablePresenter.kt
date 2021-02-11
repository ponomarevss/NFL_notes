package com.example.nflnotes.mvp.presenter

import com.example.nflnotes.mvp.view.TableView
import com.example.nflnotes.mvp.view.WeekView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class TablePresenter(val router: Router) :
    MvpPresenter<TableView>() {


    fun backPressed() = router.exit().let { true }

}