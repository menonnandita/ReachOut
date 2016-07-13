package com.nnv.reachout.utils;

import android.content.Context;

import com.kinvey.android.Client;
import com.nnv.reachout.constants.Constants;

import java.lang.ref.WeakReference;

/**
 * Created by nandita.menon on 7/12/2016.
 */
public class Config {
    private static WeakReference<Context> appContextRef;
    private static Client mKinveyClient;


    public static Context getAppContext() {
        return appContextRef.get();
    }

    public static void setAppContext(Context appContext) {
        appContextRef = new WeakReference<Context>(appContext);
    }
    public static void setKinveyClient(Context appContext) {
        mKinveyClient = new Client.Builder(Constants.APP_KEY, Constants.APP_SECRET
                , appContext).build();


    }
    public static Client getKinveyClient() {
        return mKinveyClient;
    }
}
