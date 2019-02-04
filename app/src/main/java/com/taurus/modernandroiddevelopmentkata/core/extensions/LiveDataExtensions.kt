package com.taurus.modernandroiddevelopmentkata.core.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.nonNullObserve(owner: LifecycleOwner, observer: (t: T) -> Unit) {
  this.observe(owner, Observer {
    it?.let(observer)
  })
}
