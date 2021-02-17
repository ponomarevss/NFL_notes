package com.example.nflnotes.mvp.presenter

import com.example.nflnotes.mvp.model.entity.WeekConstructor
import com.example.nflnotes.mvp.view.WeekView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class WeekPresenter(val router: Router) :
    MvpPresenter<WeekView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun getSeasons() = WeekConstructor.seasons.map { it.toString() }

    fun getWeeks() = WeekConstructor.weeks.map { "${it.seasonType} ${it.week}" }

    fun seasonSelected(pos: Int) = println("season: $pos")

    fun weekSelected(pos: Int) = println("week: $pos")

    fun backPressed() = router.exit().let { true }

}