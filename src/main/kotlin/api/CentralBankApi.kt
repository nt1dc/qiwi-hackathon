package api

import exception.DataFetchingException
import org.simpleframework.xml.core.Persister
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Date

class CentralBankApi {
    fun loadValCurs(date: Date): ValCurs? {
        val serializer = Persister()
        val fetchXmlData = fetchXmlData(date)
        println(fetchXmlData)
        return serializer.read(ValCurs::class.java, fetchXmlData)
    }

    private fun fetchXmlData(date: Date): String {
        val baseUrl = "https://www.cbr.ru/scripts/XML_daily.asp?date_req="
        val apiDate = myFormat.format(date)
        println(baseUrl + date)
        val connection = URL(baseUrl + apiDate).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.connect()

        return if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            val response = StringBuilder()
            reader.use { r ->
                var line = r.readLine()
                while (line != null) {
                    response.append(line)
                    line = r.readLine()
                }
            }
            response.toString()
        } else {
            throw DataFetchingException()
        }
    }

    private var myFormat = SimpleDateFormat("dd/MM/yyyy")

}