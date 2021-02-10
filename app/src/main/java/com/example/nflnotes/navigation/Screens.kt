package com.example.nflnotes.navigation

import com.example.nflnotes.ui.fragment.GamesFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen(): SupportAppScreen() {
        override fun getFragment() = GamesFragment.newInstance()
    }
}