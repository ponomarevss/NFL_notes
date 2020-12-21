package com.example.nflnotes.mvp.presenter

import com.example.nflnotes.mvp.model.repo.ITokenRepo
import com.example.nflnotes.mvp.view.MainView
import io.reactivex.rxjava3.core.Scheduler

class MainPresenter(
    val view: MainView,
    val mainThreadScheduler: Scheduler,
    val repo: ITokenRepo
) {

    fun loadData() = repo.getToken()
        .observeOn(mainThreadScheduler)
        .subscribe({ token ->
            token.accessToken?.let { it -> view.setTestText(it) }
            println("Here is your token: ${token.accessToken}")
        }, {
            println("Look! Here is an error: ${it.message}")
        })
}