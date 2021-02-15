package com.example.nflnotes.mvp.model.entity

import com.example.nflnotes.mvp.model.entity.query.Week

object WeekConstructor {
    val seasons = listOf(2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021)
    val weeks = listOf<Week>(
        Week(0, seasonType = "REG", week = 1),
        Week(0, seasonType = "REG", week = 2),
        Week(0, seasonType = "REG", week = 3),
        Week(0, seasonType = "REG", week = 4),
        Week(0, seasonType = "REG", week = 5),
        Week(0, seasonType = "REG", week = 6),
        Week(0, seasonType = "REG", week = 7),
        Week(0, seasonType = "REG", week = 8),
        Week(0, seasonType = "REG", week = 9),
        Week(0, seasonType = "REG", week = 10),
        Week(0, seasonType = "REG", week = 11),
        Week(0, seasonType = "REG", week = 12),
        Week(0, seasonType = "REG", week = 13),
        Week(0, seasonType = "REG", week = 14),
        Week(0, seasonType = "REG", week = 15),
        Week(0, seasonType = "REG", week = 16),
        Week(0, seasonType = "REG", week = 17)
    )
}