package com.taurus.modernandroiddevelopmentkata

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews
import androidx.navigation.NavDeepLinkBuilder

class DeepLinkAppWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val remoteViews = RemoteViews(
            context.packageName,
            R.layout.widget_deeplink
        )

        val args = Bundle()
        args.putString("title", "From Widget")

        // destination:
        // - cannot be a global action
        // - can be an id of a subgraph
        // - can be an id of a destination in a subgraph
        // - you cannot specify intermediate destinations to form a backstack
        val pendingIntent = NavDeepLinkBuilder(context)
            .setComponentName(MainActivity::class.java)
            .setGraph(R.navigation.navigation_graph)
            .setDestination(R.id.navigation_tv_series)
            .setArguments(args)
            .createPendingIntent()

        remoteViews.setOnClickPendingIntent(R.id.deepLinkButton, pendingIntent)

        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
    }
}