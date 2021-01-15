package com.example.nflnotes.mvp.model.api

import com.example.nflnotes.mvp.model.entity.query.Token
import com.example.nflnotes.mvp.model.entity.response.GamesResponse
import com.example.nflnotes.mvp.model.entity.response.TeamsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface IDataSource {

    @POST("/v1/oauth/token")
    fun authResponse(
        @Query("grant_type") grandType: String,
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String
    ): Single<Token>

    @GET("v1/games")
    fun gamesResponse(
        @Header("authorization") token: String,
        @Query("s") s: String,
    ): Single<GamesResponse>

    @GET("v1/teams")
    fun teamsResponse(
        @Header("authorization") token: String,
        @Query("s") s: String,
    ): Single<TeamsResponse>
}
