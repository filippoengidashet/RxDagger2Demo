package org.dalol.rxdaggerdemo.service;

import org.dalol.rxdaggerdemo.model.FlowerResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 3/19/2016
 */
public interface FlowerService {

    @GET("/feeds/flowers.json")
    Observable<List<FlowerResponse>> getFlowers();
}
