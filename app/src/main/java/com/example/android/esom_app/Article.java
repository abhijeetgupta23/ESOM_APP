package com.example.android.esom_app;

import android.graphics.Bitmap;

/**
 * Created by MAHE on 9/22/2017.
 */
public class Article {
    private String title, category, info,date;
    private Bitmap pic;

    public Article() {
    }

    public Article(Bitmap pic, String title, String category, String info, String date) {
        this.pic = pic;
        this.title = title;
        this.category = category;
        this.info = info;
        this.date = date;
    }

    public Bitmap getPic() {
        return pic;
    }

    public void setPic(Bitmap pic) {
        this.pic = pic;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

