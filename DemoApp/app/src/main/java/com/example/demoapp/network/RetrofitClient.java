package com.example.demoapp.network;

import com.example.demoapp.utils.Globals;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static RetrofitClient mInstance;
    private static final String BASE_URL = "https://firefight.hatoq.com/api/";

    private RetrofitClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(createInterceptor());

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    public static synchronized RetrofitClient getInstance()
    {
        if(mInstance == null)
        {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    private static Interceptor createInterceptor() {
        return chain -> {
            Request originalRequest = chain.request();
            Request.Builder builder = originalRequest.newBuilder();
            builder.header("PrivateKey", "F1r3F1ght1ng_s3cr3tk3y");
            return chain.proceed(builder.build());
        };
    }

    public Api getApi()
    {
        return retrofit.create(Api.class);
    }
}
