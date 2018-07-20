package com.gauravpunn.twitterclone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    TextView tweetbtn,yourfeedbtn;
    RecyclerView followRecycler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tweetbtn = (TextView)findViewById(R.id.TweetsBtn);
        yourfeedbtn = (TextView)findViewById(R.id.YourFeedBtn);
        followRecycler = (RecyclerView)findViewById(R.id.FollowRecycler);

        tweetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        yourfeedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
