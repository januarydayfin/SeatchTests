package com.krayapp.seatchtests

import com.krayapp.seatchtests.model.ApiModule
import com.krayapp.seatchtests.repository.GitHubApi
import com.krayapp.seatchtests.repository.GitHubRepository
import com.krayapp.seatchtests.repository.RepositoryContract
import com.krayapp.seatchtests.viewModel.SchedulerProvider
import com.krayapp.seatchtests.viewModel.SearchSchedulerProvider
import com.krayapp.seatchtests.viewModel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


object Koin {
    fun getModule() = module{
        single<GitHubApi> {ApiModule.getFromApi()}
        single<RepositoryContract>{ GitHubRepository(get()) }
        single<SchedulerProvider> { SearchSchedulerProvider() }
        viewModel {SearchViewModel(repository = get(), appSchedulerProvider = get())}
    }
}