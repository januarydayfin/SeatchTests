package com.krayapp.seatchtests.view.search

import com.krayapp.seatchtests.model.SearchResult
import com.krayapp.seatchtests.view.ViewContract

internal interface ViewSearchContract : ViewContract {
    fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    )

    fun displayError()
    fun displayError(error: String)
    fun displayLoading(show: Boolean)
}
