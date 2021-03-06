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
import com.example.nflnotes.navigation.Screens
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class GamesPresenter(val mainThreadScheduler: Scheduler, val week: Week, val repo: IDataRepo, val router: Router) :
    MvpPresenter<GamesView>() {

    class GamesListPresenter : IGamesListPresenter {
        val games = mutableListOf<Game>()
        val teams = mutableListOf<Team>()

        override var itemClickListener: ((IGameItemView) -> Unit)? = null

        override fun getCount() = games.size

        override fun bindView(view: IGameItemView) {
            val game = games[view.pos]
            initTeams(view, game)
            initScores(view, game)
        }

        private fun initScores(view: IGameItemView, game: Game) {
            if (game.isWatched) {
                view.setScore(
                    game.homeTeamScore?.pointsTotal.toString(),
                    game.visitorTeamScore?.pointsTotal.toString()
                )
            } else {
                view.setScore("", "")
            }
        }

        private fun initTeams(view: IGameItemView, game: Game) = view.setTeams(
                game.homeTeam?.id?.let { getTeamById(it)?.abbr },
                game.visitorTeam?.id?.let { getTeamById(it)?.abbr }
            )

        private fun getTeamById(teamId: String): Team? {
            var team: Team? = null
            teams.forEach {
                if (it.id == teamId)
                    team = it
            }
            return team
        }

    }

    val gamesListPresenter = GamesListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        getTeams(TeamsQuery(Season(2018)))
        getGames(GamesQuery(Week(2018, "REG", 6)))
        //todo: вводить данные из viewState

        gamesListPresenter.itemClickListener = { itemView ->
            gamesListPresenter.games[itemView.pos].isWatched = true
            viewState.updateList()
            //todo:отображать результат игры, формировать сводную таблицу
        }
    }

    fun getGames(query: GamesQuery) {
        repo.getToken()
            .subscribe({ token ->
                println("token: $token")
                repo.getGames(token, query)
                    .observeOn(mainThreadScheduler)
                    .subscribe({ gamesResponse ->
                        gamesListPresenter.games.clear()
                        gamesResponse.games?.let { it -> gamesListPresenter.games.addAll(it) }
                        viewState.updateList()
                    }, {
                        println("Can't get the gamesResponse: ${it.message}")
                    })
            }, {
                println("Can't get the authResponse: ${it.message}")
            })
    }

    fun getTeams(query: TeamsQuery) {
        repo.getToken()
            .subscribe({ token ->
                repo.getTeams(token, query)
                    .observeOn(mainThreadScheduler)
                    .subscribe({ teamsResponse ->
                        gamesListPresenter.teams.clear()
                        teamsResponse.teams?.let { it -> gamesListPresenter.teams.addAll(it) }
                        viewState.updateList()
                    }, {
                        println("Can't get the teamsResponse: ${it.message}")
                    })
            }, {
                println("Can't get the authResponse: ${it.message}")
            })
    }

    fun weekPressed() {
        router.navigateTo(Screens.WeekScreen())
    }

    fun tablePressed() {
        router.navigateTo(Screens.TableScreen())
    }

    fun backPressed() = router.exit().let { true }

}