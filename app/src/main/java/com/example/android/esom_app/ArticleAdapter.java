package com.example.android.esom_app;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.util.List;

/**
 * Created by MAHE on 9/23/2017.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    private List<Article> articlesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, category, info,date;
        private ImageView pic;

        public MyViewHolder(View view) {
            super(view);
            pic = (ImageView) view.findViewById(R.id.pic);
            title = (TextView) view.findViewById(R.id.title);
            category = (TextView) view.findViewById(R.id.category);
            info = (TextView) view.findViewById(R.id.info);
            date = (TextView) view.findViewById(R.id.date);


        }
    }

    public ArticleAdapter(List<Article> articlesList) {
        this.articlesList = articlesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Article article = articlesList.get(position);
        holder.pic.setImageBitmap(article.getPic());
        holder.title.setText(article.getTitle());
        holder.category.setText(article.getCategory());
        holder.info.setText(article.getInfo());
        holder.date.setText(article.getDate());
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }



}
