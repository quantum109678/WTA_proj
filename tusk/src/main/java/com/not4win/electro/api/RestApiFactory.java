package com.not4win.electro.api;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

class RestApiFactory {
    static RestApi getRestApi() {
        final String BASE_URL = "http://api.pricecheckindia.com/feed/product/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                // Ensures automatic JSON deserialization into required data
                .addConverterFactory(GsonConverterFactory.create())
                // Schedulers.newThread() will ensure that calls are asynchronous (not on main thread)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
                .build();

        return retrofit.create(RestApi.class);
    }
}
