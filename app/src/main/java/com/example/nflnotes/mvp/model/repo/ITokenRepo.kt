package com.example.nflnotes.mvp.model.repo

import com.example.nflnotes.mvp.model.entity.Token
import io.reactivex.rxjava3.core.Single

interface ITokenRepo {
    fun getToken(): Single<Token>
}