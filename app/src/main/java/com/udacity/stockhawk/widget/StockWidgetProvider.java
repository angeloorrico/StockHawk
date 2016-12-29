package com.udacity.stockhawk.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.udacity.stockhawk.R;
import com.udacity.stockhawk.ui.HistoricalDataActivity;

/**
 * Created by Angelo on 27/12/2016.
 */

public class StockWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidgetInfo(context, appWidgetManager, appWidgetId);
        }
    }

    private void updateAppWidgetInfo(Context context, AppWidgetManager appWidgetManager,
                                     int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.stock_widget);

        Intent intent = new Intent(context, HistoricalDataActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        //views.setOnClickPendingIntent(R.id.widget, pendingIntent);
    }

}