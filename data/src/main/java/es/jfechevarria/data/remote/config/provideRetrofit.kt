package es.jfechevarria.data.remote.config

import es.jfechevarria.data.BuildConfig.URL_BASE
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder().baseUrl(URL_BASE).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()