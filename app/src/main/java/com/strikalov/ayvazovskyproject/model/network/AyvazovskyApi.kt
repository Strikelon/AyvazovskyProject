package com.strikalov.ayvazovskyproject.model.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AyvazovskyApi {

    companion object {
        private const val URL_REQUSET = "https://my-json-server.typicode.com/strikelon/ayvazovsky_api/"
    }

    private var ayvazovskyApiService: AyvazovskyApiService

    init {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(URL_REQUSET)
            .build()

        ayvazovskyApiService = retrofit.create(AyvazovskyApiService::class.java)
    }

    fun downloadPictureList() = ayvazovskyApiService.downloadPictureList()

}