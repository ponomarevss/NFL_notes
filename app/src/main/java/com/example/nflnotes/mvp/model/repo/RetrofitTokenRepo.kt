package com.example.nflnotes.mvp.model.repo

import com.example.nflnotes.mvp.model.api.IDataSource
import com.example.nflnotes.mvp.model.entity.GamesQuery
import com.example.nflnotes.mvp.model.entity.Token
import com.example.nflnotes.mvp.model.entity.Week
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitTokenRepo(val api: IDataSource) : ITokenRepo {

    override fun getToken() = api.authResponse(
        "client_credentials",
        "dyZHpNCWN5iuPx1gdbE3Dx9JAJIzZSCQ",
        "abD8E45RS31lZIHZhqoev5Zr78JO8j4W"
    ).subscribeOn(Schedulers.io())

    override fun getGames(token: Token, query: GamesQuery) = api.gamesResponse(
        "Bearer ${token.accessToken}",
        query
    ).subscribeOn(Schedulers.io())
}