package org.dalol.rxdaggerdemo.application;

import android.app.Application;

import org.dalol.rxdaggerdemo.dependencies.ApiComponent;
import org.dalol.rxdaggerdemo.dependencies.DaggerApiComponent;
import org.dalol.rxdaggerdemo.dependencies.DaggerNetworkComponent;
import org.dalol.rxdaggerdemo.dependencies.NetworkComponent;
import org.dalol.rxdaggerdemo.dependencies.NetworkModule;
import org.dalol.rxdaggerdemo.model.Constant;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 3/19/2016
 */
public class FlowerApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }
}
