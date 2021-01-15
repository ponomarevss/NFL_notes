package com.example.nflnotes.mvp.view.list

interface IGameItemView: IItemView {
    fun setTeams(homeTeamId: String, visitorTeamId: String)
    fun setScore(homeTeamScore: Int?, visitorTeamScore: Int?)
    fun loadImage(homeTeamLogo: String, visitorTeamLogo: String)
}