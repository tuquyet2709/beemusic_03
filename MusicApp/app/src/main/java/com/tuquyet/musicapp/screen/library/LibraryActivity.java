package com.tuquyet.musicapp.screen.library;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.tuquyet.musicapp.R;
import com.example.tuquyet.musicapp.databinding.ActivityLibraryBinding;

public class LibraryActivity extends AppCompatActivity {
    private LibraryViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        LibraryAdapter libraryAdapter = new LibraryAdapter(fragmentManager);
        mViewModel = new LibraryViewModel(this, libraryAdapter);
        ActivityLibraryBinding binding =
            DataBindingUtil.setContentView(this, R.layout.activity_library);
        binding.setViewModel(mViewModel);
    }

    public static Intent getLibraryIntent(Context context) {
        Intent intent = new Intent(context, LibraryActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
}
