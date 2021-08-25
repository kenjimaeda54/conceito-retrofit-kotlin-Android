package com.example.conceitos_retrofit

import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    //recurso da url
    @GET("posts")
    fun list(): Call<List<PostModel>>
}