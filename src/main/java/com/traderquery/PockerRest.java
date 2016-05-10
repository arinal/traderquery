package com.traderquery;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

import java.util.List;

public interface PockerRest {
    @Headers("x-api-key: gaqcRZE4bd58gSAJH3XsLYBo1EvwIQo88IfYL1L5")
    @GET("prod/traders")
    Observable<List<Trader>> getTraders();

    @Headers("x-api-key: gaqcRZE4bd58gSAJH3XsLYBo1EvwIQo88IfYL1L5")
    @GET("prod/transactions")
    Observable<List<Transaction>> getTransactions();
}
