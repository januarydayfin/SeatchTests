package com.krayapp.seatchtests.repository

import com.krayapp.seatchtests.model.SearchResponse
import retrofit2.Response


internal class FakeGitHubRepository : RepositoryContract {

    override fun searchGithub(
        query: String,
        callback: RepositoryCallback
    ) {
        callback.handleGitHubResponse(Response.success(SearchResponse(42, listOf())))
    }
}