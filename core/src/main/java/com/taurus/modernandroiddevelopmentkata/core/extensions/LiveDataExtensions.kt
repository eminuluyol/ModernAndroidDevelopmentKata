package com.taurus.modernandroiddevelopmentkata.core.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.taurus.modernandroiddevelopmentkata.core.livedata.Event
import com.taurus.modernandroiddevelopmentkata.core.livedata.EventObserver

fun <T> LiveData<T>.nonNullObserve(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, Observer {
        it?.let(observer)
    })
}

fun <T> LiveData<Event<T>>.nonNullObserveEvent(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, EventObserver {
        it?.let(observer)
    })
}