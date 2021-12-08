package com.krayapp.seatchtests.presenter.search

import com.krayapp.seatchtests.presenter.PresenterContract

internal interface PresenterSearchContract : PresenterContract {
    fun searchGitHub(searchQuery: String)
    //onAttach
    //onDetach
}
