package com.example.android.topictracker;

/**
 * Created by lixiaochi on 18/1/17.
 */

public class News {
    private String title;
    private String content;
    public News(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }
}
