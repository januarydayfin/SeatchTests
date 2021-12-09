package com.krayapp.seatchtests.presenter.details

import com.krayapp.seatchtests.view.ViewContract
import com.krayapp.seatchtests.view.details.ViewDetailsContract

internal class DetailsPresenter internal constructor(
    private val viewContract: ViewDetailsContract,
    private var count: Int = 0
) : PresenterDetailsContract {

    private var currentView: ViewDetailsContract? = null

    val testView: ViewContract?
        get() = currentView

    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement(): Int {
        count++
        viewContract.setCount(count)
        return count
    }

    override fun onDecrement(): Int {
        count--
        viewContract.setCount(count)
        return count
    }

    override fun onAttach() {
        currentView = viewContract
    }

    override fun onDetach() {
        currentView = null
    }
}
