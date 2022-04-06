package com.stanislavkorneev.valute1

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup


class ValuteLoader {

    private val contentUrl = "https://www.cbr-xml-daily.ru/daily_json.js"
    private val textObjects = ArrayList<String>()
    private val resultList = ArrayList<Valute>()

    suspend fun loadContent(): List<Valute> {
        return withContext(Dispatchers.IO) {

            val json = Jsoup.connect(contentUrl).ignoreContentType(true).get().text()
            val startIndexes = ArrayList<Int>()
            val endIndexes = ArrayList<Int>()

            for (i in json.indices) {
                val c: Char = json[i]
                if (c == '{')
                    startIndexes.add(i)
                if (c == '}')
                    endIndexes.add(i)
            }

            for (i in 2 until startIndexes.size) {
                textObjects.add(json.substring(startIndexes[i], endIndexes[i - 2] + 1))
            }

            val gson = Gson()

            for (item in textObjects) {
                var valute: Valute = gson.fromJson(item, Valute::class.java)
                resultList.add(valute)
            }

            resultList
        }
    }

}