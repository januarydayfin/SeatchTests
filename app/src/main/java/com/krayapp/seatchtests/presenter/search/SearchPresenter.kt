package com.krayapp.seatchtests.presenter.search

import com.krayapp.seatchtests.model.SearchResponse
import com.krayapp.seatchtests.repository.GitHubRepository
import com.krayapp.seatchtests.repository.GitHubRepository.GitHubRepositoryCallback
import com.krayapp.seatchtests.repository.RepositoryCallback
import com.krayapp.seatchtests.repository.RepositoryContract
import com.krayapp.seatchtests.view.search.ViewSearchContract
import retrofit2.Response

/**
 * В архитектуре MVP все запросы на получение данных адресуются в Репозиторий.
 * Запросы могут проходить через Interactor или UseCase, использовать источники
 * данных (DataSource), но суть от этого не меняется.
 * Непосредственно Презентер отвечает за управление потоками запросов и ответов,
 * выступая в роли регулировщика движения на перекрестке.
 */

internal class SearchPresenter internal constructor(
    private val viewContract: ViewSearchContract,
    private val repository: RepositoryContract
) : PresenterSearchContract, RepositoryCallback {

    private var currentRepo: RepositoryContract? = null

    val testRepoStatus: RepositoryContract?
        get() = currentRepo

    override fun searchGitHub(searchQuery: String) {
        viewContract.displayLoading(true)
        repository.searchGithub(searchQuery, this)
    }

    override fun onAttach() {
        currentRepo = this.repository
    }

    override fun onDetach() {
        currentRepo = null
    }

    override fun handleGitHubResponse(response: Response<SearchResponse?>?) {
        viewContract.displayLoading(false)
        if (response != null && response.isSuccessful) {
            val searchResponse = response.body()
            val searchResults = searchResponse?.searchResults
            val totalCount = searchResponse?.totalCount
            if (searchResults != null && totalCount != null) {
                viewContract.displaySearchResults(
                    searchResults,
                    totalCount
                )
            } else {
                viewContract.displayError("Search results or total count are null")
            }
        } else {
            viewContract.displayError("Response is null or unsuccessful")
        }
    }

    override fun handleGitHubError() {
        viewContract.displayLoading(false)
        viewContract.displayError()
    }
}
