package com.example.nflnotes.mvp.model.repo

import com.example.nflnotes.mvp.model.api.IDataSource
import com.example.nflnotes.mvp.model.entity.Token
import com.example.nflnotes.mvp.model.entity.User
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitTokenRepo(val api: IDataSource, val user: User) : ITokenRepo {
    override fun getToken() = api.getToken(user).subscribeOn(Schedulers.io())
}