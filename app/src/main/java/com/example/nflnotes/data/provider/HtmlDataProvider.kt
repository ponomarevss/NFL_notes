package com.example.nflnotes.data.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nflnotes.data.entity.Game
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

class HtmlDataProvider : IDataProvider {

    companion object{
        private const val BASE_URL = "https://www.nfl.com/schedules/2020/REG1/"
    }
    override fun getGames(): LiveData<List<Game>> {
        val result = MutableLiveData<List<Game>>()
        GlobalScope.launch {
            getData()
        }
        return result
    }

    private fun getData() : List<Game>? {
        val result : MutableList<Game>?
        val document = Jsoup.connect(BASE_URL).get()
        val element = document.select("div[nfl-c-matchup-strip nfl-c-matchup-strip--post-game]")

        for (i in 0 until  element.size) {
            val hostName : String = element.select("div[nfl-c-matchup-strip__game]")
                .select("div[nfl-c-matchup-strip__team nfl-c-matchup-strip__team--opponent]")
                .select("p[nfl-c-matchup-strip__team-name]")
                .select("span[nfl-c-matchup-strip__team-abbreviation]")
                .eq(i)
                .text()

            val hostScore : String = element.select("div[nfl-c-matchup-strip__game]")
                .select("div[nfl-c-matchup-strip__team nfl-c-matchup-strip__team--opponent]")
                .select("div[nfl-c-matchup-strip__team-score]")
                .eq(i)
                .text()

            val guestName : String = element.select("div[nfl-c-matchup-strip__game]")
                .select("div[nfl-c-matchup-strip__team]")
                .select("p[nfl-c-matchup-strip__team-name]")
                .select("span[nfl-c-matchup-strip__team-abbreviation]")
                .eq(i)
                .text()

            val guestScore : String = element.select("div[nfl-c-matchup-strip__game]")
                .select("div[nfl-c-matchup-strip__team]")
                .select("div[nfl-c-matchup-strip__team-score]")
                .eq(i)
                .text()

            val game = Game(hostName, hostScore, guestName, guestScore)
            result.add(game)
        }

        return result
    }
}