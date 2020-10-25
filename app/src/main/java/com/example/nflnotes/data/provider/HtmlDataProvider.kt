package com.example.nflnotes.data.provider

import com.example.nflnotes.data.entity.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class HtmlDataProvider : IDataProvider {

    override fun getGames(url: String): List<Game> {
        val result = mutableListOf<Game>()
        GlobalScope.launch {
            val elements = getGamesData(url)
            GlobalScope.launch(Dispatchers.Main) {
                for (i in elements.size - 1 downTo 0) {
                    val game : Game = renderGameData(elements[i])
                    result.add(game)
                }
            }
        }
        return result
    }

    private fun renderGameData(element: Element): Game {
        val hostName = element
            .select("a.team.helper-team-name")[0]
            .text()
        val guestName = element
            .select("a.team.helper-team-name")[1]
            .text()

        val gameResult = element.select("td.total-score")
        val hostScore = when(gameResult.size) {
            2 -> gameResult[0].text()
            else -> "-"
        }
        val guestScore = when(gameResult.size) {
            2 -> gameResult[1].text()
            else -> "-"
        }
        return Game(hostName, hostScore, guestName, guestScore)
    }

    private fun getGamesData(url : String) : Elements {
        val document = Jsoup.connect(url).get()
        return document.select("div.in-progress-table.section")
    }
}