package com.taurus.modernandroiddevelopmentkata.core.extensions

import com.taurus.modernandroiddevelopmentkata.BuildConfig

inline fun debug(body: () -> Unit) {
  if (BuildConfig.DEBUG) body()
}