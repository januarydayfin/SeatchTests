package com.krayapp.seatchtests.presenter.details

import com.krayapp.seatchtests.presenter.PresenterContract

internal interface PresenterDetailsContract : PresenterContract {
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()
}
