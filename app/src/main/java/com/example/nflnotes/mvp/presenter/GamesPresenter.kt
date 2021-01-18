package com.example.nflnotes.mvp.presenter

import com.example.nflnotes.mvp.model.entity.Game
import com.example.nflnotes.mvp.model.repo.IDataRepo
import com.example.nflnotes.mvp.presenter.list.IGamesListPresenter
import com.example.nflnotes.mvp.view.GamesView
import com.example.nflnotes.mvp.view.list.IGameItemView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter

class GamesPresenter(val mainThreadScheduler: Scheduler, val repo: IDataRepo) :
    MvpPresenter<GamesView>() {

    class GamesListPresenter: IGamesListPresenter {
        val games = mutableListOf<Game>()

        override var itemClickListener: ((IGameItemView) -> Unit)? = null

        override fun getCount() = games.size

        override fun bindView(view: IGameItemView) {
            val game = games[view.pos]
            view.setTeams(game.homeTeam?.id, game.visitorTeam?.id)
            view.setScore(game.homeTeamScore?.pointsTotal, game.visitorTeamScore?.pointsTotal)
        }
    }

    val gamesListPresenter = GamesListPresenter()

}

// class MainPresenter(val view: MainView, val mainThreadScheduler: Scheduler, val repo: IDataRepo) {
//
//    fun loadData() = repo.getToken()
//        .observeOn(mainThreadScheduler)
//        .subscribe({ authResponse ->
//            authResponse.accessToken?.let {
//                view.setTokenText(it)
//            }
//            println("Here is your TOKEN: ${authResponse.accessToken}")
//            loadGames(authResponse, GamesQuery(Week(2018, "REG", 6)))
//            loadTeams(authResponse, TeamsQuery(Season(2018)))
//        }, {
//            println("Can't get your TOKEN: ${it.message}")
//        })
//
//    fun loadGames(token: Token, query: GamesQuery) = repo.getGames(token, query)
//        .observeOn(mainThreadScheduler)
//        .subscribe({
//            it.games?.get(0)?.let { game -> view.setGamesText(game.toString()) }
//            println("Here is your GAMES: $it")
//        },{
//            println("Can't get your GAMES: ${it.message}")
//        })
//
//    fun loadTeams(token: Token, query: TeamsQuery) = repo.getTeams(token, query)
//        .observeOn(mainThreadScheduler)
//        .subscribe({
//            it.teams?.get(0)?.let { team -> view.setTeamsText(team.toString()) }
//            println("Here is your TEAMS: $it")
//        },{
//            println("Can't get your TEAMS: ${it.message}")
//        })
//
//}