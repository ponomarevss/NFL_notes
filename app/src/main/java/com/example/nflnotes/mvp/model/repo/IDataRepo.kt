package com.example.nflnotes.mvp.model.repo

import com.example.nflnotes.mvp.model.entity.games.GamesQuery
import com.example.nflnotes.mvp.model.entity.Token
import com.example.nflnotes.mvp.model.entity.games.TeamsQuery
import com.example.nflnotes.mvp.model.entity.response.GamesResponse
import com.example.nflnotes.mvp.model.entity.response.TeamsResponse
import io.reactivex.rxjava3.core.Single

interface IDataRepo {
//    fun getToken(): Single<Token>
    fun getGames(query: GamesQuery): Single<GamesResponse>
    fun getTeams(query: TeamsQuery): Single<TeamsResponse>
//    fun getGames(token: Token, query: GamesQuery): Single<GamesResponse>
//    fun getTeams(token: Token, query: TeamsQuery): Single<TeamsResponse>
}