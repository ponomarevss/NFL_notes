package com.example.nflnotes.mvp.model.repo

import com.example.nflnotes.mvp.model.entity.games.TeamsQuery
import com.example.nflnotes.mvp.model.entity.query.Token
import com.example.nflnotes.mvp.model.entity.response.TeamsResponse
import io.reactivex.rxjava3.core.Single

interface ITeamsRepo {
    fun getTeams(token: Token, query: TeamsQuery): Single<TeamsResponse>
}