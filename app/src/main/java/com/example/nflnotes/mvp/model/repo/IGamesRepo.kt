package com.example.nflnotes.mvp.model.repo

import com.example.nflnotes.mvp.model.entity.games.GamesQuery
import com.example.nflnotes.mvp.model.entity.query.Token
import com.example.nflnotes.mvp.model.entity.response.GamesResponse
import io.reactivex.rxjava3.core.Single

interface IGamesRepo {
    fun getGames(token: Token, query: GamesQuery): Single<GamesResponse>
}