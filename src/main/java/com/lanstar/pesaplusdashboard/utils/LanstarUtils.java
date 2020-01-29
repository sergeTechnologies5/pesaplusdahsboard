package com.lanstar.pesaplusdashboard.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.lanstar.pesaplusdashboard.Response.CustomerMO;
import com.lanstar.pesaplusdashboard.Response.SaccoResponse;
import com.lanstar.pesaplusdashboard.payload.User;
import com.lanstar.pesaplusdashboard.retrofit.network.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@Component
public class LanstarUtils {

    @Autowired
    ApiClient apiClient;


    public List<SaccoResponse> getAllSaccos(User user) throws IOException {
        apiClient.setAuthToken(user.getToken());
        List<SaccoResponse> saccoResponseList=new ArrayList<>();
        Response<String> response = apiClient.getService().getAllSaccos().execute();
        if (response.isSuccessful()) {
            assert response.body() != null;
            // JsonArray jsonArray = new JsonParser().parse(response.body()).getAsJsonArray();
            Gson gson = new Gson();
            String jsonOutput = response.body();
            Type listType = new TypeToken<List<SaccoResponse>>(){}.getType();
            saccoResponseList = gson.fromJson(jsonOutput, listType);

//            for ( JsonElement jsonObject:jsonArray) {
//                JsonObject jsonObject1=  jsonObject.getAsJsonObject();
//                SaccoResponse saccoResponse=new SaccoResponse(jsonObject1.get("saccoID").getAsLong(),
//                        jsonObject1.get("saccoName").getAsString());
//                saccoResponseList.add(saccoResponse);
//            }
        } else {
            System.out.println("Error:::"+response.errorBody());
        }
        return saccoResponseList;
    }

    public List<CustomerMO> getCustomerMO(User user) throws IOException {
        apiClient.setAuthToken(user.getToken());
        List<CustomerMO> customerMOList=new ArrayList<>();
        Response<String> response = apiClient.getService().getMnos().execute();
        if (response.isSuccessful()) {
            assert response.body() != null;
            JsonArray jsonArray = new JsonParser().parse(response.body()).getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = new JsonParser().parse(jsonArray.get(i).toString()).getAsJsonObject();
                CustomerMO customerMO=new CustomerMO(jsonObject.get("id").getAsLong(),
                        jsonObject.get("operatorName").getAsString(),
                        jsonObject.get("phoneNumber").getAsString(),
                        jsonObject.get("serviceName").getAsString());
                customerMOList.add(customerMO);
            }
        } else {
            System.out.println("Error:::"+response.errorBody());
        }
        return customerMOList;
    }

}
