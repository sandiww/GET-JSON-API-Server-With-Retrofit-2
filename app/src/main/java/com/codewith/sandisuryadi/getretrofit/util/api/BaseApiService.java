package com.codewith.sandisuryadi.getretrofit.util.api;

import com.codewith.sandisuryadi.getretrofit.model.ResponseDosen;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApiService {
    @GET("semuadosen")
    Call<ResponseDosen> getSemuaDosen();
}
