package es.jfechevarria.data.remote.config

import retrofit2.Retrofit

fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)