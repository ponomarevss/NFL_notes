package com.example.nflnotes.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nflnotes.R
import com.example.nflnotes.mvp.model.api.ApiHolder
import com.example.nflnotes.mvp.model.repo.RetrofitDataRepo
import com.example.nflnotes.mvp.presenter.GamesPresenter
import com.example.nflnotes.mvp.view.GamesView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity(), GamesView {

    val presenter = GamesPresenter(this, AndroidSchedulers.mainThread(), RetrofitDataRepo(ApiHolder.api))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.loadData()

    }

}