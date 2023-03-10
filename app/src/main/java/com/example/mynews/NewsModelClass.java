package com.example.mynews;

import java.util.ArrayList;

public class NewsModelClass {
    private String status;
    private int totalResults;
    private ArrayList<ArticlesModelClass> articles;

    public NewsModelClass(String status, int totalResults, ArrayList<ArticlesModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ArticlesModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ArticlesModelClass> articles) {
        this.articles = articles;
    }
}
