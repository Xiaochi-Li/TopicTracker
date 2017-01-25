package com.example.android.topictracker;

import android.app.LoaderManager;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiaochi on 25/1/17.
 */

public class ShowNews extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<List<News>> {
    private TextView mEmptyStateTextView;
    private View loadingIndicator;
    private NewsAdapter mNewsAdapter;
    private static final String NEWS_REQUEST_URL = "https://content.guardianapis.com/search?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize the gridView
        GridView newsPageGridView = (GridView) findViewById(R.id.news_page_grid_view);
        //fill it with news Items.

        mNewsAdapter = new NewsAdapter(this, new ArrayList<News>());
        newsPageGridView.setAdapter(mNewsAdapter);

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(1, null, this);
        Log.i("initLoader", "Loader1 initialed");
    }

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String searchKey = sharedPrefs.getString(getString(R.string.settings_search_word_key), getString(R.string.settings_search_word_default));
        Uri baseUri = Uri.parse(NEWS_REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter("q", searchKey);

        uriBuilder.appendQueryParameter("format", "json");

        uriBuilder.appendQueryParameter("order-by", "newest");
        uriBuilder.appendQueryParameter("api-key", "test");

        Log.i("onCreateLoader", uriBuilder.toString());

        NewsLoader ld =new NewsLoader(ShowNews.this, uriBuilder.toString());
        return ld;
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> bookList) {
        loadingIndicator.setVisibility(View.GONE);
        mNewsAdapter.clear();
        if (bookList != null && !bookList.isEmpty()) {
            mNewsAdapter.addAll(bookList);
        } else{
            mEmptyStateTextView.setText("No searching result");
        }

    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

    }

}
