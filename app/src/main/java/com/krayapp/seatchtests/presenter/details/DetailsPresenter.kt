package com.krayapp.seatchtests.presenter.details

import com.krayapp.seatchtests.view.details.ViewDetailsContract

internal class DetailsPresenter internal constructor(
    private val viewContract: ViewDetailsContract,
    private var count: Int = 0
) : PresenterDetailsContract {
    override fun onAttach() {
        TODO("Not yet implemented")
    }

    override fun onDetach() {
        TODO("Not yet implemented")
    }

    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement() {
        count++
        viewContract.setCount(count)
    }

    override fun onDecrement() {
        count--
        viewContract.setCount(count)
    }
}
