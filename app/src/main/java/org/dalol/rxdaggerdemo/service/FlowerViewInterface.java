package org.dalol.rxdaggerdemo.service;

import org.dalol.rxdaggerdemo.model.FlowerResponse;

import java.util.List;

import rx.Observable;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 3/19/2016
 */
public interface FlowerViewInterface {

    void onCompleted();

    void onError(String message);

    void onFlowers(List<FlowerResponse> flowerResponses);

    Observable<List<FlowerResponse>> getFlowers();
}
