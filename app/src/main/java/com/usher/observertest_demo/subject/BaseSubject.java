package com.usher.observertest_demo.subject;

import com.usher.observertest_demo.observer.BaseObserver;

/**
 * Created by UsherChen on 2017/8/11.
 * Details 被观察者
 */

public interface BaseSubject {

    //注册行为
    void subscribe(BaseObserver observer);

    //解注册行为
    void unSubscribe(BaseObserver observer);

    //通知观察者
    void notify2Observer(String info);

}
