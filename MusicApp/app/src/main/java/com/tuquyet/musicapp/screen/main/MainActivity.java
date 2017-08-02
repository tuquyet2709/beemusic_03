package com.tuquyet.musicapp.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tuquyet.musicapp.R;
import com.example.tuquyet.musicapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new MainViewModel(this, this.getApplicationContext());
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mViewModel);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
