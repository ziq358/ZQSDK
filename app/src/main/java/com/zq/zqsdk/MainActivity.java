package com.zq.zqsdk;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ziq.base.dagger.component.AppComponent;
import com.ziq.base.mvp.BaseActivity;

public class MainActivity extends BaseActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    public int initLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void initForInject(AppComponent appComponent) {

    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}
