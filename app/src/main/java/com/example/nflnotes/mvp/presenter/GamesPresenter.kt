package com.example.nflnotes.mvp.presenter

import com.example.nflnotes.mvp.model.entity.Game
import com.example.nflnotes.mvp.model.entity.Team
import com.example.nflnotes.mvp.model.entity.games.GamesQuery
import com.example.nflnotes.mvp.model.entity.games.TeamsQuery
import com.example.nflnotes.mvp.model.entity.query.Season
import com.example.nflnotes.mvp.model.entity.query.Week
import com.example.nflnotes.mvp.model.repo.IDataRepo
import com.example.nflnotes.mvp.presenter.list.IGamesListPresenter
import com.example.nflnotes.mvp.view.GamesView
import com.example.nflnotes.mvp.view.list.IGameItemView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter

class GamesPresenter(private val mainThreadScheduler: Scheduler, private val repo: IDataRepo) :
    MvpPresenter<GamesView>() {

    class GamesListPresenter : IGamesListPresenter {
        val games = mutableListOf<Game>()
        val teams = mutableListOf<Team>()

        override var itemClickListener: ((IGameItemView) -> Unit)? = null

        override fun getCount() = games.size

        override fun bindView(view: IGameItemView) {
            val game = games[view.pos]
            view.setTeams(
                game.homeTeam?.id?.let { getTeamById(it)?.abbr },
                game.visitorTeam?.id?.let { getTeamById(it)?.abbr }
            )
            view.setScore(game.homeTeamScore?.pointsTotal, game.visitorTeamScore?.pointsTotal)
        }

        private fun getTeamById(teamId : String) : Team? {
            lateinit var team : Team
            teams?.forEach {
                if (it.id == teamId)
                    team = it
            }
            return team
        }

    }

    private val gamesListPresenter = GamesListPresenter()

    private fun getGames(query: GamesQuery) {
        repo.getGames(query)
            .observeOn(mainThreadScheduler)
            .subscribe({ gamesResponse ->
                gamesListPresenter.games.clear()
                gamesResponse.games?.let { it -> gamesListPresenter.games.addAll(it) }
            }, {
                println("Can't get the gamesResponse: ${it.message}")
            })
        viewState.updateList()
    }

    private fun getTeams(query: TeamsQuery) {
        repo.getTeams(query)
            .observeOn(mainThreadScheduler)
            .subscribe({teamsResponse ->
                gamesListPresenter.teams.clear()
                teamsResponse.teams?.let { gamesListPresenter.teams.addAll(it) }
            }, {
                println("Can't get teamsResponse: ${it.message}")
            })
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        getGames(GamesQuery(Week(2018, "REG", 6)))
        getTeams(TeamsQuery(Season(2018)))
        //todo: вводить данные из viewState

        gamesListPresenter.itemClickListener = { itemView ->
            //todo:отображать результат игры, формировать сводную таблицу
        }
    }
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