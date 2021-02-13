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
                .setMessage("加载中...")//设置提示文字
                .setCancelable(true)//按返回键取消
                .setMessageColor(Color.WHITE)//提示文字颜色
                .setMessageSize(14)//提示文字字号
                .setBackgroundTransparent(true)//弹窗背景色是透明或半透明
                .setCancelOutside(true);//点击空白区域弹消失
        LoadingDialog dialog = loadBuilder.create();
        dialog.show();
    }
}