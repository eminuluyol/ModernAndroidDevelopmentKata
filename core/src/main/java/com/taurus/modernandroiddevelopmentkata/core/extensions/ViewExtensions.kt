package com.taurus.modernandroiddevelopmentkata.core.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

fun View.isVisible() = visibility == View.VISIBLE

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visibility(isVisible: Boolean) = if (isVisible) this.visible() else this.gone()

fun Iterable<Fragment>.hideAllExcept(fragmentToShow: Fragment) = this.forEach {
    if (it == fragmentToShow) it.view?.visible() else it.view?.gone()
}
