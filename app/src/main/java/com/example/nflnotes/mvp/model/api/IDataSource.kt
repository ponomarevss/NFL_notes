package com.example.nflnotes.mvp.model.api

import com.example.nflnotes.mvp.model.entity.Token
import com.example.nflnotes.mvp.model.entity.User
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PUT

interface IDataSource {

    @PUT("/v2/users")
    fun getToken(@Body user: User): Single<Token>

}