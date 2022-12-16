package com.if3a.paimonopedia.api;

import com.if3a.paimonopedia.models.Artifacts;
import com.if3a.paimonopedia.models.Characters;
import com.if3a.paimonopedia.models.Weapons;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRequestData {
    @GET("characters")
    Call<List<Characters>> getCharacters();

//    @GET("characters")
//    Call<List<talents>> ardTalents(@Query("expand") String talents);

    @GET("artifacts")
    Call<List<Artifacts>> getArtifacts();

    @GET("weapons")
    Call<List<Weapons>> getWeapons();
}
