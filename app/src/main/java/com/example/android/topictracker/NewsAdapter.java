package com.example.android.topictracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


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
                    inflate(R.layout.news_items,parent,false);
            /*inflate(int resource, ViewGroup root, boolean attachToRoot)
            Inflate a new view hierarchy from the specified xml resource.*/
        }

        News currentNew = (News) getItem(position);

        //creat Views and put all content into them.
        TextView title =(TextView) newsItemView.findViewById(R.id.news_title);
        title.setText(currentNew.getTitle());

        TextView content = (TextView) newsItemView.findViewById(R.id.news_content);
        content.setText(currentNew.getContent());

        //remember to return something.
        return newsItemView;
    }
}
