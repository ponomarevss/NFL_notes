package com.example.nflnotes.mvp.presenter

import com.example.nflnotes.mvp.model.entity.GamesQuery
import com.example.nflnotes.mvp.model.entity.Token
import com.example.nflnotes.mvp.model.entity.Week
import com.example.nflnotes.mvp.model.repo.ITokenRepo
import com.example.nflnotes.mvp.view.MainView
import io.reactivex.rxjava3.core.Scheduler

class MainPresenter(val view: MainView, val mainThreadScheduler: Scheduler, val repo: ITokenRepo) {

    fun loadData() = repo.getToken()
        .observeOn(mainThreadScheduler)
        .subscribe({ authResponse ->
            authResponse.accessToken?.let {
                view.setTokenText(it)
            }
            println("Here is your TOKEN: ${authResponse.accessToken}")
            loadGames(authResponse, GamesQuery(Week()))
        }, {
            println("Can't get your TOKEN: ${it.message}")
        })

    fun loadGames(token: Token, query: GamesQuery) = repo.getGames(token, query)
        .observeOn(mainThreadScheduler)
        .subscribe({
            view.setGamesText(it)
            println("Here is your GAMES: $it")
        },{
            println("Can't get your GAMES: ${it.message}")
        })
}