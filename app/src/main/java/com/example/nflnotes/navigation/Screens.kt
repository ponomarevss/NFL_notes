package com.example.nflnotes.navigation

import com.example.nflnotes.ui.fragment.GamesFragment
import com.example.nflnotes.ui.fragment.TableFragment
import com.example.nflnotes.ui.fragment.WeekFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class GamesScreen(): SupportAppScreen() {
        override fun getFragment() = GamesFragment.newInstance()
    }

    class WeekScreen(): SupportAppScreen() {
        override fun getFragment() = WeekFragment.newInstance()
    }

    class TableScreen(): SupportAppScreen() {
        override fun getFragment() = TableFragment.newInstance()
    }
}