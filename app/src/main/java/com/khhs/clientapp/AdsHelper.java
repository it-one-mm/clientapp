package com.khhs.clientapp;

import android.content.Context;
import android.util.Log;

import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;

public class AdsHelper
        implements AudienceNetworkAds.InitListener {

    /**
     * It's recommended to call this method from Application.onCreate().
     * Otherwise you can call it from all Activity.onCreate()
     * methods for Activities that contain ads.
     *
     * @param context Application or Activity.
     */
    static void initialize(Context context) {
        if (!AudienceNetworkAds.isInitialized(context)) {
            if (BuildConfig.DEBUG) {
                AdSettings.turnOnSDKDebugger(context);
            }

            AudienceNetworkAds
                    .buildInitSettings(context)
                    .withInitListener(new AdsHelper())
                    .initialize();
        }
    }

    @Override
    public void onInitialized(AudienceNetworkAds.InitResult result) {
        Log.d(AudienceNetworkAds.TAG, result.getMessage());
    }
}
