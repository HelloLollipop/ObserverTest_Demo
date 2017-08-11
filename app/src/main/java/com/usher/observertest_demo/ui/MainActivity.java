package com.usher.observertest_demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.usher.observertest_demo.R;
import com.usher.observertest_demo.observer.Observer1;
import com.usher.observertest_demo.observer.Observer2;
import com.usher.observertest_demo.observer.OnGetInfoFromSubjectListener;
import com.usher.observertest_demo.subject.RealSubject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvInfoFromObserver1;
    private TextView mTvInfoFromObserver2;
    private Button mBtnSubscribe;
    private Button mBtnNotify;

    private RealSubject mRealSubject;
    private Observer1 mObserver1;
    private Observer2 mObserver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initAction();
        initData();
    }

    private void initData() {
        if (mRealSubject == null) {
            mRealSubject = new RealSubject();
        }
        if (mObserver1 == null) {
            mObserver1 = new Observer1();
            mObserver1.setOnGetInfoFromSubjectListener(new OnGetInfoFromSubjectListener() {
                @Override
                public void onGetInfo(String info) {
                    mTvInfoFromObserver1.setText(info);
                }
            });
        }
        if (mObserver2 == null) {
            mObserver2 = new Observer2();
            mObserver2.setOnGetInfoFromSubjectListener(new OnGetInfoFromSubjectListener() {
                @Override
                public void onGetInfo(String info) {
                    mTvInfoFromObserver2.setText(info);
                }
            });
        }
    }

    private void initAction() {
        mBtnSubscribe.setOnClickListener(this);
        mBtnNotify.setOnClickListener(this);
    }

    private void initView() {
        mTvInfoFromObserver1 = (TextView) findViewById(R.id.tv_info_from_observer1);
        mTvInfoFromObserver2 = (TextView) findViewById(R.id.tv_info_from_observer2);
        mBtnSubscribe = (Button) findViewById(R.id.btn_subscribe);
        mBtnNotify = (Button) findViewById(R.id.btn_notify);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == mBtnSubscribe.getId()) {
            mRealSubject.subscribe(mObserver1);
            mRealSubject.subscribe(mObserver2);
        }
        if (id == mBtnNotify.getId()) {
            mRealSubject.sendInfo2Observer();
        }
    }
}
