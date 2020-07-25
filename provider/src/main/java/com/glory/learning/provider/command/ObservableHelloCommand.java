package com.glory.learning.provider.command;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * 返回多个数据的command
 *
 * @author Glory
 * @create 2020-05-30 23:45
 **/
public class ObservableHelloCommand extends HystrixObservableCommand<String> {

    public ObservableHelloCommand() {
        super(HystrixObservableCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ob-helloServiceGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("ob-hello-response")));
    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    subscriber.onNext("Hello GLory");
                    subscriber.onNext("Hi Lina");
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io());
    }
}
