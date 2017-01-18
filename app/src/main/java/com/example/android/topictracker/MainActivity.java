package com.example.android.topictracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NewsAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //testList
        List<News> newsTestList = new ArrayList<>();
        News n1 = new News("1","fdsafsdafsdaf");
        newsTestList.add(n1);
        News n2 = new News("2","fdsafsdafsdaf");
        newsTestList.add(n2);
        News n3 = new News("3","fdsafsdafsdaf");
        newsTestList.add(n3);
        News n4 = new News("4","fdsafsdafsdaf");
        newsTestList.add(n4);

        //initialize the gridView
        GridView newsPageGridView = (GridView) findViewById(R.id.news_page_grid_view);
        //fill it with news Items.

        mNewsAdapter = new NewsAdapter(this, newsTestList);
        newsPageGridView.setAdapter(mNewsAdapter);
    }
}


