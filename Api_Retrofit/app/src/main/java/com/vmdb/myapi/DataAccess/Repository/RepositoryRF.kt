package com.vmdb.myapi.DataAccess.Repository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryRF {
    companion object{
        val url = "https://gorest.co.in/public/v1/"
        fun GetConnection() : Retrofit{
            val logging = HttpLoggingInterceptor()
            logging.level = (HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)
            return Retrofit.Builder()
                .baseUrl(url)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}