package com.example.android.esom_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MAHE on 9/23/2017.
 */



public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {



    private List<Article> articlesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, category, info,date,ReadMore;
        private ImageView picture;
        private String link;

        public MyViewHolder(View view) {
            super(view);
            picture = (ImageView) view.findViewById(R.id.pic);
            title = (TextView) view.findViewById(R.id.title);
            category = (TextView) view.findViewById(R.id.category);
            info = (TextView) view.findViewById(R.id.info);
        //    date = (TextView) view.findViewById(R.id.date);
            link = "";
            ReadMore = (TextView) view.findViewById(R.id.ReadMore);


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
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Article article = articlesList.get(position);
        holder.title.setText(article.getTitle());
        Picasso.with(holder.picture.getContext()).load(article.getPic()).into(holder.picture);
        holder.category.setText(article.getCategory());
        holder.info.setText(article.getInfo());
//        holder.date.setText(article.getDate());
        holder.link= article.getLink();
        holder.ReadMore.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Context context = v.getContext();
                intent.setClass(context,WebViewActivity.class);

                //Set your data using putExtra method which take
                //any key and value which we want to send
                intent.putExtra("linkArticle",holder.link);

                //Use startActivity or startActivityForResult for Starting New Activity
                context.startActivity(intent);
            }

        });

    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }



}
