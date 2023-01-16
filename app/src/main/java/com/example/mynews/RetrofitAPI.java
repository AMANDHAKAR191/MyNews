package com.example.mynews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET
    Call<NewsModelClass> getAllNews(@Url String url);

    @GET
    Call<NewsModelClass> getNewsByCategory(@Url String url);


}
