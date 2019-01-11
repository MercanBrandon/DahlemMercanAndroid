package com.example.merca.dahlemmercan.api

import retrofit2.Call
import com.example.merca.dahlemmercan.models.Follower
import retrofit2.http.GET

interface GitHubInterface {


    @GET("/users")
    fun getAllFollowers(): Call<List<Follower>>
}
