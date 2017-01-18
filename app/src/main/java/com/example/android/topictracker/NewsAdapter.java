package com.example.android.topictracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import static android.R.id.list;

/**
 * Created by lixiaochi on 18/1/17.
 */

public class NewsAdapter extends ArrayAdapter {


    public NewsAdapter(Context context, List<News> newsList){
        super(context,0,newsList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View newsItemView = convertView;
        if(newsItemView == null){
            newsItemView = LayoutInflater.from(getContext()).
                    inflate(R.layout.activity_main,parent,false);
        }

        News currentNew = (News) getItem(position);

        //creat Views and put all content into them.
        TextView title =(TextView) newsItemView.findViewById(R.id.news_title);
        title.setText(currentNew.getTitle());

        TextView content = (TextView) newsItemView.findViewById(R.id.news_content);
        content.setText(currentNew.getContent());
        return null;
    }
}
