package com.krayapp.seatchtests

import com.krayapp.seatchtests.presenter.details.DetailsPresenter
import com.krayapp.seatchtests.presenter.search.SearchPresenter
import com.krayapp.seatchtests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {
    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    private var count:Int = 0

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailsPresenter(viewContract, count)
    }

    @Test
    fun testIncrementViewCounter() {
        presenter.onIncrement()
        val count: Int = 1
        verify(viewContract, times(1)).setCount(count)
    }

    @Test
    fun testDecrementViewCounter() {
        presenter.onDecrement()
        val count: Int = -1
        verify(viewContract, times(1)).setCount(count)
    }

    @Test
    fun OnIncrementTest() {
        assertEquals(1 , presenter.onIncrement())
    }
    @Test
    fun OnDecrementTest() {
        assertEquals(-1 , presenter.onDecrement())
    }

    @Test
    fun onAttachTest() {
        presenter.onAttach()
        assertNotNull(presenter.testView)
    }

    @Test
    fun onDetachTest() {
        presenter.onDetach()
        assertNull(presenter.testView)
    }
}