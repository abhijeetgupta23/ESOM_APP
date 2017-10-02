package com.example.android.esom_app;

import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Article> articleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ArticleAdapter aAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        aAdapter = new ArticleAdapter(articleList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // set the adapter
        recyclerView.setAdapter(aAdapter);

        prepareArticleData();



    }

    private void prepareArticleData() {
        Article article = new Article(R.drawable.esom_logo, "Here's why Gender Equality is taking so long", "Recent","There are many headwinds that can lengthen the time required for desired systemic change","5 hours ago");
        articleList.add(article);

        article = new Article(R.drawable.img_lights, "Here's why Gender Equality is taking so long", "Recent","There are many headwinds that can lengthen the time required for desired systemic change","5 hours ago");
        articleList.add(article);

        article = new Article(R.drawable.esom_logo, "Here's why Gender Equality is taking so long", "Recent","There are many headwinds that can lengthen the time required for desired systemic change","5 hours ago");
        articleList.add(article);

        article = new Article(R.drawable.esom_logo, "Here's why Gender Equality is taking so long", "Recent","There are many headwinds that can lengthen the time required for desired systemic change","5 hours ago");
        articleList.add(article);

        article = new Article(R.drawable.esom_logo, "Here's why Gender Equality is taking so long", "Recent","There are many headwinds that can lengthen the time required for desired systemic change","5 hours ago");
        articleList.add(article);

        aAdapter.notifyDataSetChanged();

    }

}
