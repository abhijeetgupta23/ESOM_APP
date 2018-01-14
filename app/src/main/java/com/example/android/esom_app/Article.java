package com.example.android.esom_app;

/**
 * Created by MAHE on 9/22/2017.
 */
public class Article {
    private String title, category, info,date;
    private String pic,link;



    public Article(String pic, String title, String category, String info, String date,String link) {
        this.pic = pic;
        this.title = title;
        this.category = category;
        this.info = info;
        this.date = date;
        this.link=link;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

