package com.nnv.reachout;

import com.nnv.reachout.utils.Config;

/**
 * Created by nandita.menon on 7/12/2016.
 */
public class ROApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Config.setAppContext(this);
        Config.setKinveyClient(this);
    }
}
