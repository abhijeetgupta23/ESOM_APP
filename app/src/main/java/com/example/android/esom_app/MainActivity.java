package com.example.android.esom_app;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Article> articleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ArticleAdapter aAdapter;

    //Variables to Scrape Data

    String url ="http://esom.club/blog";
    ProgressDialog mProgressDialog;
    Elements imageSet;

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

                    //Get all images



                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

        @Override
        protected void onPostExecute(Void result) {
            // Set the articles

//            Log.d("myTag", articles.toString());

            for(org.jsoup.nodes.Element x : articles) {

              //  Log.d("myTag", x.toString());
                   Elements category = x.select("[rel='category tag']");
                    Elements img = x.select("img[src~=(?i)\\.(png|jpe?g)]");
                    Elements title = x.select("[rel='bookmark']");
                    Elements info = x.select(".entry-excerpt");
                    String link =  title.attr("href");;
                    Log.d("link", link);
                    String imgSrc = img.attr("src");
                    Log.d("myTag", imgSrc);

                       /* Download image from URL
                InputStream input = null;
                try {
                    input = new java.net.URL(imgSrc).openStream();
                } catch (IOException e) {
                    e.printStackTrace();
                } */

                    // Decode Bitmap
                    //   Bitmap bitmap = BitmapFactory.decodeStream(input);


                    Article article = new Article(imgSrc, title.html(), category.html(), info.select("p").text(), null,link);
                    articleList.add(article);
                    aAdapter.notifyDataSetChanged();


            }



            mProgressDialog.dismiss();
        }



    }

}
