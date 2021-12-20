package com.krayapp.seatchtests.viewModel

import io.reactivex.Scheduler


interface SchedulerProvider {
    fun ui(): Scheduler
    fun io(): Scheduler
}