package com.gauri.retrofitsimpledemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface JsonPlaceHolderApi {

    @GET("posts") //this is called annotation,it is pointing to something
    Call<List<Post>> getPosts();
}
