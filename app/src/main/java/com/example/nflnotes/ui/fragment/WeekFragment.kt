package com.example.nflnotes.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.nflnotes.R
import com.example.nflnotes.mvp.presenter.WeekPresenter
import com.example.nflnotes.mvp.view.WeekView
import com.example.nflnotes.ui.App
import com.example.nflnotes.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_week.*
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
            ArrayAdapter(it, android.R.layout.simple_spinner_item, presenter.getSeasons())
        }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        season_spinner.adapter = adapter
        season_spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                presenter.seasonSelected(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun setWeeks() {
        val adapter = context?.let {
            ArrayAdapter(it, android.R.layout.simple_spinner_item, presenter.getWeeks())
        }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        week_spinner.adapter = adapter
        week_spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                presenter.weekSelected(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    override fun backPressed() = presenter.backPressed()

}