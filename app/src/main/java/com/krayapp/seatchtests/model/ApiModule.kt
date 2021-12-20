package com.krayapp.seatchtests.model

import com.krayapp.seatchtests.repository.GitHubApi
import com.krayapp.seatchtests.view.search.MainActivity
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiModule {
    fun getFromApi():GitHubApi{
        return Retrofit.Builder()
            .baseUrl(MainActivity.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubApi::class.java)
    }
}