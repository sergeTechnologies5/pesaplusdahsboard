package com.lanstar.pesaplusdashboard.retrofit.network;



import java.util.List;

import com.lanstar.pesaplusdashboard.model.Customer;
import com.lanstar.pesaplusdashboard.model.CustomerModel;
import com.lanstar.pesaplusdashboard.model.Sacco;
import  com.lanstar.pesaplusdashboard.payload.SigninRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    // List all groups
    @GET("api/groups")
    Call<String> getGroups();

    // ---------------------------------------------------------------------------------------------

    // -------------------------------- USER ACCOUNTS ------------------------------ //

    // Sign In
    @POST("auth/token/test")
    Call<String> login(@Body SigninRequest request);

    // create sacco
    @POST("api/v1/saccos")
    Call<String> createSacco(@Body Sacco request);


    // create Customer
    @POST("api/v1/member")
    Call<String> createCustomer(@Body CustomerModel request);



}
