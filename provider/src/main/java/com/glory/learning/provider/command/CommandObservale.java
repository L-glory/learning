package com.glory.learning.provider.command;

import rx.Observable;
import rx.Observer;

/**
 * @author Glory
 * @create 2020-05-31 13:05
 **/
public class CommandObservale {

    public String observe() {
        // 调用observe方法，command会立即执行
        Observable<String> ob = new HelloCommand().observe();
        String resp = ob.toBlocking().single();
        assert "glory".equals(resp);
        ob.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(String s) {
            }
        });
        return resp;
    }

    public String toObservable() {
        // 调用toObservable方法，不会command会立即执行，直到调用ob.subscribe之后才执行
        Observable<String> ob = new HelloCommand().toObservable();
        String resp = ob.toBlocking().single();
        assert "glory".equals(resp);
        ob.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(String s) {
            }
        });
        return resp;
    }
}
