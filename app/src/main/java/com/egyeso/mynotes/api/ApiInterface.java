package com.egyeso.mynotes.api;

import com.egyeso.mynotes.models.Note;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("myapi/save.php")
    Call<Note> SaveNote(@Field("title") String title,
                        @Field("note") String note,
                        @Field("color") int color);

    @FormUrlEncoded
    @POST("myapi/update.php")
    Call<Note> UpdateNote(
                        @Field("id") int id,
                        @Field("title") String title,
                        @Field("note") String note,
                        @Field("color") int color);

    @FormUrlEncoded
    @POST("myapi/delete.php")
    Call<Note> DeleteNote(@Field("id") int id);


    @GET("myapi/notes.php")
    Call<List<Note>> getNotes();
}
