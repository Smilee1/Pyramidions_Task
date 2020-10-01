package com.example.Pyramidions.Retrofit;

import com.example.Pyramidions.Response.EmployeeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import static com.example.Pyramidions.Constant.AppConstants.PATH;

public interface ApiRequest {
    @GET(PATH)
    Call<EmployeeResponse> getEmployeeList();
}
