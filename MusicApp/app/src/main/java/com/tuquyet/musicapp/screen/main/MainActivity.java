package com.tuquyet.musicapp.screen.main;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.tuquyet.musicapp.R;
import com.example.tuquyet.musicapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static int REQUEST_WRITE_EXTERNAL_STORAGE = 123;
    private MainViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new MainViewModel(this, this.getApplicationContext());
        ActivityCompat.requestPermissions(MainActivity.this,
            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
            REQUEST_WRITE_EXTERNAL_STORAGE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout
                    .activity_main);
                binding.setViewModel(mViewModel);
            } else {
                Toast.makeText(this, R.string.permission_denied_please_grant_permission, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
