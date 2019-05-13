package com.taurus.modernandroiddevelopmentkata.main

import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.navigation.NavController

fun NavController.initWith(@NavigationRes graphId: Int, @IdRes startDestinationId: Int) = apply {
    graph = navInflater.inflate(graphId).apply {
        startDestination = startDestinationId
    }
}