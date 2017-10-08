package com.sabututexp.everyonejournalist.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by s on 10/8/17.
 */

public class ServiceHolder {
    public static final String BASE_URL = "http://everyone-journalist.tutexp.com/api/";

    private static Retrofit.Builder retroBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);


    private static Retrofit retrofit = retroBuilder.build();

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(logging)) {
            //add interceptor
            httpClient.addInterceptor(logging);
            //rebuild the retrofit client
            retroBuilder.client(httpClient.build());
            //re-initialize the retrofit instance
            retrofit = retroBuilder.build();
        }
        return retrofit.create(serviceClass);
    }
}
