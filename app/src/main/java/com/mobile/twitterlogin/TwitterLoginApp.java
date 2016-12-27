package com.mobile.twitterlogin;

import android.app.Application;
import android.content.Context;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;


/**
 * Created by Rio Swarawan on 5/24/2016.
 */
public class TwitterLoginApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig("ImhcwUB1xfQckKU4l8n7D90QZ", "\tdx9hDQa7rtT2BwXiCFWFpu4TpQlESaGuSotVEgCFUB3wBEHAO1");
        Fabric.with(this, new Twitter(authConfig));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
