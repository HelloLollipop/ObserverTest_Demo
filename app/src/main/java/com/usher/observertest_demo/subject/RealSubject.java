package com.usher.observertest_demo.subject;

/**
 * Created by UsherChen on 2017/8/11.
 * Details
 */

public class RealSubject extends Subject {

    private String mInfo = "I am a subject and was subscribed by ~ ";

    public void sendInfo2Observer() {
        notify2Observer(mInfo);
    }

}
