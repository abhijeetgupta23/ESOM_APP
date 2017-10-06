package com.example.android.esom_app;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.thumbnail;
import static android.R.attr.x;

public class MainActivity extends AppCompatActivity {

    private List<Article> articleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ArticleAdapter aAdapter;

    //Variables to Scrape Data

    String url ="http://esom.club/blog";
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

    //Recycler view code
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        aAdapter = new ArticleAdapter(articleList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // set the adapter
        recyclerView.setAdapter(aAdapter);



     //Prepare Article Data using web scraping
        new Data().execute();



    }

    private class Data extends AsyncTask<Void, Void, Void> {

        Elements articles;

        //To show load bar
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mProgressDialog = new ProgressDialog(MainActivity.this);
                mProgressDialog.setTitle("ESOM Blog");
                mProgressDialog.setMessage("Loading...");
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.show();
            }

        //Get data from Websiteusing Web Scraping

            @Override
            protected Void doInBackground(Void... params) {
                try {

                    // Connect to the web site
                    Document document = Jsoup.connect(url).get();
                    // Get the articles
                    articles = document.getElementsByTag("article");


                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

        @Override
        protected void onPostExecute(Void result) {
            // Set the articles


            for(org.jsoup.nodes.Element x : articles) {

                Elements img = x.getElementsByTag("img[src~=(?i)\\.(png|jpe?g)]");
                Elements title = x.select("[rel='bookmark']");
                Elements info = x.select("at-above-post-homepage addthis_tool");

               String imgSrc = img.attr("src");

                // Download image from URL
                InputStream input = null;
                try {
                    input = new java.net.URL(imgSrc).openStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Decode Bitmap
                Bitmap bitmap = BitmapFactory.decodeStream(input);



               Article article = new Article(bitmap, title.html(), "Recent", info.select("p").html(), "5 hours ago");
               articleList.add(article);
               aAdapter.notifyDataSetChanged();

            }



            mProgressDialog.dismiss();
        }



    }

}
