package com.lanstar.pesaplusdashboard.retrofit.network;



import com.lanstar.pesaplusdashboard.model.CustomerModel;
import com.lanstar.pesaplusdashboard.model.Sacco;
import  com.lanstar.pesaplusdashboard.payload.SigninRequest;

import com.lanstar.pesaplusdashboard.request.CustomerChangePin;
import org.springframework.web.bind.annotation.PathVariable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    //  USER

    // Sign In
    @POST("auth/token/test")
    Call<String> login(@Body SigninRequest request);


    // ---------------------------------------------------------------------------------------------

    // -------------------------------- CUSTOMER ACCOUNTS ------------------------------ //


    // create Customer
    @POST("api/v1/member")
    Call<String> createCustomer(@Body CustomerModel request);

    @GET("api/v1/member/all?status=0")
    Call<String> getCustomers();

    @GET("api/v1/member/all?status=1")
    Call<String> getActiveCustomers();

    //reset customer pin
    @POST("api/v1/member/reset-pin")
    Call<String> resetCustomerPin(@Body CustomerChangePin request);

    //activate Customer
    @GET("api/v1/member/approve-member")
    Call<String> activateCustomer(@Query("customerID")  Long customerID);


    //    SACCOS

    // create sacco
    @POST("api/v1/saccos")
    Call<String> createSacco(@Body Sacco request);

    @GET("api/v1/saccos/s")
    Call<String> getSaccos();


    //     MOBILE OPERATORS

    // List all Mobile Number Operators
    @GET("api/v1/mno")
    Call<String> getMnos();


}
