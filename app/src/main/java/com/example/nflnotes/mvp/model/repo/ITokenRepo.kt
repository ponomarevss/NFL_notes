package com.example.nflnotes.mvp.model.repo

import com.example.nflnotes.mvp.model.entity.GamesQuery
import com.example.nflnotes.mvp.model.entity.Token
import com.example.nflnotes.mvp.model.entity.Week
import io.reactivex.rxjava3.core.Single

interface ITokenRepo {
    fun getToken(): Single<Token>
    fun getGames(token: Token, query: GamesQuery): Single<String>
}