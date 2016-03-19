package org.dalol.rxdaggerdemo.dependencies;

import org.dalol.rxdaggerdemo.service.FlowerService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 3/19/2016
 */
@Module
public class ApiModule {

    @Provides
    @CustomScope
    FlowerService provideFlowerService(Retrofit retrofit) {
        return retrofit.create(FlowerService.class);
    }
}
