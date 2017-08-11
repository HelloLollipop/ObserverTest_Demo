package com.usher.observertest_demo.subject;

import com.usher.observertest_demo.observer.BaseObserver;

import java.util.ArrayList;

/**
 * Created by UsherChen on 2017/8/11.
 * Details
 */

public abstract class Subject implements BaseSubject {

    private ArrayList<BaseObserver> mObserverList = new ArrayList<>();

    @Override
    public void subscribe(BaseObserver observer) {
        mObserverList.add(observer);
    }

    @Override
    public void unSubscribe(BaseObserver observer) {
        mObserverList.remove(observer);
    }

    @Override
    public void notify2Observer(String info) {
        for (BaseObserver observer : mObserverList) {
            observer.update(info);
        }
    }
}
