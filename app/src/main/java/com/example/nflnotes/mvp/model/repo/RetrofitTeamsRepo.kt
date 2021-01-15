package com.example.nflnotes.mvp.model.repo

import com.example.nflnotes.mvp.model.api.IDataSource
import com.example.nflnotes.mvp.model.entity.AuthData
import com.example.nflnotes.mvp.model.entity.games.GamesQuery
import com.example.nflnotes.mvp.model.entity.query.Token
import com.example.nflnotes.mvp.model.entity.games.TeamsQuery
import com.google.gson.Gson
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitTeamsRepo(val api: IDataSource) : ITeamsRepo {

    val gson = Gson()

    override fun getTeams(token: Token, query: TeamsQuery) = api.teamsResponse(
        "Bearer ${token.accessToken}",
        gson.toJson(query)
    ).subscribeOn(Schedulers.io())

}