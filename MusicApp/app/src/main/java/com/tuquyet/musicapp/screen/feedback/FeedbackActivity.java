package com.tuquyet.musicapp.screen.feedback;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tuquyet.musicapp.R;
import com.example.tuquyet.musicapp.databinding.ActivityFeedbackBinding;

public class FeedbackActivity extends AppCompatActivity {
    private FeedBackContract.ViewModel mViewModel;

    public static Intent getFeedbackIntent(Context context) {
        Intent intent = new Intent(context, FeedbackActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFeedbackBinding binding =
            DataBindingUtil.setContentView(this, R.layout.activity_feedback);
        mViewModel = new FeedBackViewModel(this);
        binding.setViewModel((FeedBackViewModel) mViewModel);
    }
}
