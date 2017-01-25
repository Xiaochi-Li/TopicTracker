package com.example.android.topictracker;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by lixiaochi on 23/1/17.
 */

public class NewsLoader extends AsyncTaskLoader {
    private String mUrl;
    NewsLoader(Context context, String url){
        super(context);
        mUrl =url;
    }

    @Override
    public Object loadInBackground() {
        if (mUrl == null){
            return null;
        }
        return QuerryUtils.fetchNewsData(mUrl);
    }
}
