package com.mobile.twitterlogin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class TimelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.list_item);

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("fabric")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();

        //setListAdapter(adapter);
        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Use a more specific parent
                final ViewGroup parentView = (ViewGroup) getWindow().getDecorView().getRootView();
                // TODO: Base this Tweet ID on some data from elsewhere in your app
                long tweetId = 631879971628183552L;
                TweetUtils.loadTweet(tweetId, new Callback<Tweet>() {
                    @Override
                    public void success(Result<Tweet> result) {
                        TweetView tweetView = new TweetView(TimelineActivity.this, result.data);
                        parentView.addView(tweetView);
                    }
                    @Override
                    public void failure(TwitterException exception) {
                        Log.d("TwitterKit", "Load Tweet failure", exception);
                    }
                });

            }
        });

    }

}
