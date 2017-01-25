package com.example.android.topictracker;



public class News {
    private String title;
    private String publictime;
    public News(String title, String content){
        this.title = title;
        this.publictime = content;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return publictime;
    }
}
