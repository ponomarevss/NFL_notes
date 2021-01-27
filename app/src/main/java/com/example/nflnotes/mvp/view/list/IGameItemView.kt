package com.example.nflnotes.mvp.view.list

interface IGameItemView: IItemView {
    fun setTeams(homeTeam: String?, visitorTeam: String?)
    fun setScore(homeTeamScore: String?, visitorTeamScore: String?)
    fun loadImage(homeTeamLogo: String?, visitorTeamLogo: String?)
}