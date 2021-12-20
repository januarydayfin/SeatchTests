package com.krayapp.seatchtests.repository

import com.krayapp.seatchtests.model.SearchResponse
import io.reactivex.Observable

interface RepositoryContract {
    fun searchGithub(
        query: String,
        callback: RepositoryCallback
    )

    fun searchGithub(
        query: String
    ): Observable<SearchResponse>
}