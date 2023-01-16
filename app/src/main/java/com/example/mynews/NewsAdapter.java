package com.example.mynews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private ArrayList<ArticlesModelClass> articlesDataHolder;
    private Context context;

    public NewsAdapter(ArrayList<ArticlesModelClass> articlesDataHolder, Context context) {
        this.articlesDataHolder = articlesDataHolder;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_news_cardview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticlesModelClass articles = articlesDataHolder.get(position);
        holder.tvNewsHeading.setText(articles.getTitle());
        holder.tvNewsSubtitle.setText(articles.getDescription());
        Picasso.get().load(articles.getUrlToImage()).into(holder.imgArticle);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsDetailsActivity.class);
                intent.putExtra("title", articles.getTitle());
                intent.putExtra("content", articles.getContent());
                intent.putExtra("desc", articles.getDescription());
                intent.putExtra("image", articles.getUrlToImage());
                intent.putExtra("url", articles.getUrl());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return articlesDataHolder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNewsHeading, tvNewsSubtitle;
        private ImageView imgArticle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNewsHeading = itemView.findViewById(R.id.tv_news_heading);
            tvNewsSubtitle = itemView.findViewById(R.id.tv_news_subtitle);
            imgArticle = itemView.findViewById(R.id.img_article);
        }
    }
}
