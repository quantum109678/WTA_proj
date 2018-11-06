package com.not4win.electro.api;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface RestApi {
    @GET("mobile_phones.json")
    Observable<ProductResponse> getMobilePhones(@Query("user") String user,
                                                @Query("key") String key);

    @GET("laptops.json")
    Observable<ProductResponse> getLaptops(@Query("user") String user,
                                           @Query("key") String key);

    @GET("washing_machines.json")
    Observable<ProductResponse> getWashingMachines(@Query("user") String user,
                                                    @Query("key") String key);

    @GET("refrigerators.json")
    Observable<ProductResponse> getRefrigerators(@Query("user") String user,
                                                 @Query("key") String key);

    @GET("speakers.json")
    Observable<ProductResponse> getSpeakers(@Query("user") String user,
                                            @Query("key") String key);

    @GET("gaming_consoles.json")
    Observable<ProductResponse> getGamingConsoles(@Query("user") String user,
                                                @Query("key") String key);
}
