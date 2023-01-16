package com.example.mynews;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailsActivity extends AppCompatActivity {
    String title, description, urlToImage, url, content;
    private TextView tvNewsHeading, tvNewsSubtitle, tvNewsContent;
    private ImageView imgArticle;
    Button btnReadMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        tvNewsHeading = findViewById(R.id.tv_news_heading);
        tvNewsSubtitle = findViewById(R.id.tv_news_subtitle);
        tvNewsContent = findViewById(R.id.tv_news_content);
        imgArticle = findViewById(R.id.img_article);
        btnReadMore = findViewById(R.id.btn_read_more);

        title = getIntent().getStringExtra("title");
        description = getIntent().getStringExtra("desc");
        urlToImage = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");
        content = getIntent().getStringExtra("content");

        tvNewsHeading.setText(title);
        tvNewsSubtitle.setText(description);
        tvNewsContent.setText(content);
        Picasso.get().load(urlToImage).into(imgArticle);
        btnReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


    }

    public void goBack(View view) {
        finish();
    }
}