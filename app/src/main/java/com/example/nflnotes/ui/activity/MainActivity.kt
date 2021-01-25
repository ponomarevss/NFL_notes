package com.example.nflnotes.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nflnotes.R
import com.example.nflnotes.mvp.model.api.ApiHolder
import com.example.nflnotes.mvp.model.repo.RetrofitDataRepo
import com.example.nflnotes.mvp.presenter.GamesPresenter
import com.example.nflnotes.mvp.view.GamesView
import com.example.nflnotes.ui.adapter.GamesRVAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), GamesView {

    private val presenter by moxyPresenter {
        GamesPresenter(AndroidSchedulers.mainThread(), RetrofitDataRepo(ApiHolder.api))
    }
    var adapter: GamesRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun init() {
        rv_games.layoutManager = LinearLayoutManager(this)
        adapter = GamesRVAdapter(presenter.gamesListPresenter)
        rv_games.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}