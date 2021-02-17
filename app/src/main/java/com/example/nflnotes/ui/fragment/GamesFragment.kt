package com.example.nflnotes.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nflnotes.R
import com.example.nflnotes.mvp.model.api.ApiHolder
import com.example.nflnotes.mvp.model.entity.query.Week
import com.example.nflnotes.mvp.model.repo.RetrofitDataRepo
import com.example.nflnotes.mvp.presenter.GamesPresenter
import com.example.nflnotes.mvp.view.GamesView
import com.example.nflnotes.ui.App
import com.example.nflnotes.ui.BackButtonListener
import com.example.nflnotes.ui.adapter.GamesRVAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_games.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class GamesFragment : MvpAppCompatFragment(), GamesView, BackButtonListener {

    companion object {
        private const val WEEK = "week"
        fun newInstance(week: Week) = GamesFragment().apply {
            arguments = Bundle().apply { this.putParcelable(WEEK, week) }
        }
    }

    private val presenter by moxyPresenter {
        val week = arguments?.getParcelable<Week>(WEEK) as Week
        GamesPresenter(AndroidSchedulers.mainThread(), week, RetrofitDataRepo(ApiHolder.api), App.instance.router)
    }
    var adapter: GamesRVAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_games, null)


    override fun init() {
        rv_games.layoutManager = LinearLayoutManager(requireContext())
        adapter = GamesRVAdapter(presenter.gamesListPresenter)
        rv_games.adapter = adapter

        btn_week.setOnClickListener { presenter.weekPressed() }
        btn_table.setOnClickListener { presenter.tablePressed() }
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

}