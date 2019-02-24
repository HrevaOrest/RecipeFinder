package com.project.project.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

   // String myId = "a32da703";
    //String myKey = "eb4aca3d5ea0be63e8d37232830ac3df";

        @GET("recipes?_app_id=a32da703&_app_key=eb4aca3d5ea0be63e8d37232830ac3df&q=q")
        Call<JsonObject> getObject (@Query("q") String q);
}
