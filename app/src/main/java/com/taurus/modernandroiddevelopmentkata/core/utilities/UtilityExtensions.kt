package com.taurus.modernandroiddevelopmentkata.core.utilities

import com.taurus.modernandroiddevelopmentkata.BuildConfig

inline fun debug(body: () -> Unit) {
  if (BuildConfig.DEBUG) body()
}
