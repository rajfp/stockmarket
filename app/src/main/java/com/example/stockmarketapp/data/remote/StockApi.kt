package com.example.stockmarketapp.data.remote

import com.example.stockmarketapp.data.remote.dto.CompanyInfoDto
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {
    @GET("/query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String = API_KEY
    ): ResponseBody

    @GET("/query?function=TIME_SERIES_INTRADAY")
    suspend fun getIntradayInfo(
        @Query("symbol") symbol: String,
        @Query("interval") interval: String = "60min",
        @Query("apikey") apiKey: String = API_KEY,
        @Query("datatype") datatype: String = "csv"

    ): ResponseBody

    @GET("/query?function=OVERVIEW")
    suspend fun getCompanyInfo(
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = API_KEY
    ): CompanyInfoDto

    companion object {
        const val API_KEY = "demo"
        const val BASE_URL = "https://www.alphavantage.co"
    }
}