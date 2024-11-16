package com.bankapp16nov.network;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SoapApi {

    @Headers({
            "Content-Type: text/xml",
            "SOAPAction: \"http://ws.soap.com/getComptes\""
    })
    @POST("ws") // Replace "ws" with the correct endpoint path
    Call<String> getComptes(@Body RequestBody body);

    @Headers({
            "Content-Type: text/xml",
            "SOAPAction: \"http://ws.soap.com/getCompteById\""
    })
    @POST("ws")
    Call<String> getCompteById(@Body RequestBody body);

    @Headers({
            "Content-Type: text/xml",
            "SOAPAction: \"http://ws.soap.com/createCompte\""
    })
    @POST("ws")
    Call<String> createCompte(@Body RequestBody body);

    @Headers({
            "Content-Type: text/xml",
            "SOAPAction: \"http://ws.soap.com/deleteCompte\""
    })
    @POST("ws")
    Call<String> deleteCompte(@Body RequestBody body);
}
