package com.example.nflnotes.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nflnotes.R
import com.example.nflnotes.mvp.presenter.list.IGamesListPresenter
import com.example.nflnotes.mvp.view.list.IGameItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_game.*

class GamesRVAdapter(val presenter: IGamesListPresenter) :
    RecyclerView.Adapter<GamesRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        ).apply {
            containerView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        presenter.bindView(holder)
    }

    override fun getItemCount() = presenter.getCount()

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer, IGameItemView {

        override var pos = -1

        override fun setTeams(homeTeam: String?, visitorTeam: String?) = with(containerView) {
            homeTeam_tv.text = homeTeam
            visitorTeam_tv.text = visitorTeam
        }

        override fun setScore(homeTeamScore: String?, visitorTeamScore: String?) = with(containerView) {
            homeTeamScore_tv.text = homeTeamScore
            visitorTeamScore_tv.text = visitorTeamScore
        }

        override fun loadImage(homeTeamLogo: String?, visitorTeamLogo: String?) {
            TODO("Not yet implemented")
        }
    }

}