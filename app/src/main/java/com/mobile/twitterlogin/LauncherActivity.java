package com.mobile.twitterlogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

import java.sql.Time;

public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = null;

        if (checkUserIsNoSignedIn())
            intent = new Intent(this, MainActivity.class);
        else{
            intent = new Intent(this, TimelineActivity.class);
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    private boolean checkUserIsNoSignedIn() {
        //return false;
        TwitterSession session = Twitter.getSessionManager().getActiveSession();
        return session == null;
    }
}
