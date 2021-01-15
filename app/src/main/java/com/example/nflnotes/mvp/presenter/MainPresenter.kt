package com.example.nflnotes.mvp.presenter

import com.example.nflnotes.mvp.model.entity.query.Season
import com.example.nflnotes.mvp.model.entity.games.GamesQuery
import com.example.nflnotes.mvp.model.entity.query.Token
import com.example.nflnotes.mvp.model.entity.query.Week
import com.example.nflnotes.mvp.model.entity.games.TeamsQuery
import com.example.nflnotes.mvp.model.repo.IDataRepo
import com.example.nflnotes.mvp.view.MainView
import io.reactivex.rxjava3.core.Scheduler

class MainPresenter(val view: MainView, val mainThreadScheduler: Scheduler, val repo: IDataRepo) {

    fun loadData() = repo.getToken()
        .observeOn(mainThreadScheduler)
        .subscribe({ authResponse ->
            authResponse.accessToken?.let {
                view.setTokenText(it)
            }
            println("Here is your TOKEN: ${authResponse.accessToken}")
            loadGames(authResponse, GamesQuery(Week(2018, "REG", 6)))
            loadTeams(authResponse, TeamsQuery(Season(2018)))
        }, {
            println("Can't get your TOKEN: ${it.message}")
        })

    fun loadGames(token: Token, query: GamesQuery) = repo.getGames(token, query)
        .observeOn(mainThreadScheduler)
        .subscribe({
            it.games?.get(0)?.let { game -> view.setGamesText(game.toString()) }
            println("Here is your GAMES: $it")
        },{
            println("Can't get your GAMES: ${it.message}")
        })

    fun loadTeams(token: Token, query: TeamsQuery) = repo.getTeams(token, query)
        .observeOn(mainThreadScheduler)
        .subscribe({
            it.teams?.get(0)?.let { team -> view.setTeamsText(team.toString()) }
            println("Here is your TEAMS: $it")
        },{
            println("Can't get your TEAMS: ${it.message}")
        })

}