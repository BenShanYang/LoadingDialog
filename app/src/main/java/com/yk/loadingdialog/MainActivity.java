package com.yk.loadingdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.yk.loading.LoadingDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadingDialog.Builder loadBuilder = new LoadingDialog.Builder(this)
                .setMessage("加载中...")
                .setCancelable(true)
                .setMessageColor(Color.WHITE)
                .setMessageSize(14)
                .setBackgroundTransparent(true)
                .setCancelOutside(true);
        LoadingDialog dialog = loadBuilder.create();
        dialog.show();
    }
}