package com.example.nflnotes.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nflnotes.R
import com.example.nflnotes.mvp.model.api.ApiHolder
import com.example.nflnotes.mvp.model.repo.RetrofitDataRepo
import com.example.nflnotes.mvp.presenter.GamesPresenter
import com.example.nflnotes.mvp.presenter.WeekPresenter
import com.example.nflnotes.mvp.view.GamesView
import com.example.nflnotes.mvp.view.WeekView
import com.example.nflnotes.ui.App
import com.example.nflnotes.ui.BackButtonListener
import com.example.nflnotes.ui.adapter.GamesRVAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_games.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class WeekFragment : MvpAppCompatFragment(), WeekView, BackButtonListener {

    companion object {
        fun newInstance() = WeekFragment()
    }

    private val presenter by moxyPresenter {
        WeekPresenter(App.instance.router)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_week, null)

    override fun init() {
        setSeasons()
        setWeeks()
    }

    private fun setSeasons() {
        val adapter = context?.let {
            ArrayAdapter<String>(it, android.R.layout.simple_spinner_item, presenter.getSeasons())
        }
    }

    private fun setWeeks() {
        val adapter = context?.let {
            ArrayAdapter<String>(it, android.R.layout.simple_spinner_item, presenter.getWeeks())
        }
    }

    override fun backPressed() = presenter.backPressed()

}