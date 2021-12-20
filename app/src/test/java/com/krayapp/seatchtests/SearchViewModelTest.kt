package com.krayapp.seatchtests

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.krayapp.seatchtests.model.SearchResponse
import com.krayapp.seatchtests.repository.FakeGitHubRepository
import com.krayapp.seatchtests.viewModel.ScheduleProviderStub
import com.krayapp.seatchtests.viewModel.SearchViewModel
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class SearchViewModelTest {

    private lateinit var searchViewModel: SearchViewModel

    @Mock
    private lateinit var repository: FakeGitHubRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        searchViewModel = SearchViewModel(repository, ScheduleProviderStub())
    }

    companion object {
        private const val SEARCH_QUERY = "some query"
        private const val ERROR_TEXT = "error"
    }
}