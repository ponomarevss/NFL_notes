package com.example.nflnotes.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    @Expose val id: String?,
    @Expose val homeTeam: Rival?,
    @Expose val visitorTeam: Rival?,
    @Expose val homeTeamScore: Score?,
    @Expose val visitorTeamScore: Score?,
    var isWatched: Boolean = false
): Parcelable