package com.udacity.stockhawk.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import com.udacity.stockhawk.data.Contract;

/**
 * Created by Angelo on 26/12/2016.
 */

public class HistoricalDataActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    private Cursor mCursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = new Bundle();

        getSupportLoaderManager().initLoader(MainActivity.STOCK_LOADER, bundle, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, Contract.Quote.URI,
                new String[]{ Contract.Quote.COLUMN_PRICE},
                Contract.Quote.COLUMN_SYMBOL + " = ?",
                new String[]{args.getString("")},
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mCursor = data;

        fillLineSet();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void fillLineSet(){
        mCursor.moveToFirst();

        /*for (int i = 0; i < mCursor.getCount(); i++){
            float price = Float.parseFloat(mCursor.getString(mCursor.getColumnIndex(QuoteColumns.BIDPRICE)));
            mLineSet.addPoint("test " + i, price);
            mCursor.moveToNext();
        }
        mLineSet.setColor(getResources().getColor(R.color.line_set))
                .setDotsStrokeThickness(Tools.fromDpToPx(2))
                .setDotsStrokeColor(getResources().getColor(R.color.line_stroke))
                .setDotsColor(getResources().getColor(R.color.line_dots));
        lineChartView.addData(mLineSet);
        lineChartView.show();*/
    }

}