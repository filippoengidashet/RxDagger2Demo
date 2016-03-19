package org.dalol.rxdaggerdemo.base;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 3/19/2016
 */
public interface Presenter {

    void onCreate();

    void onPause();

    void onResume();

    void onDestroy();
}
