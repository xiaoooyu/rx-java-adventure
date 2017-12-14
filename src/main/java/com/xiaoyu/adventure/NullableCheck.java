package com.xiaoyu.adventure;

import io.reactivex.Observable;
import io.reactivex.plugins.RxJavaPlugins;

public class NullableCheck {

    public static void main(String[] args) {
        // will cause NPE
//        Observable.just(null)
//                .doOnNext(a -> System.out.println("onNext"))
//                .doOnError(error -> System.out.println(error.getMessage()))
//                .subscribe((a) -> System.out.println("onNext in subscrition"));

        RxJavaPlugins.setErrorHandler(e -> System.out.println(e.getMessage()));

        Observable.fromCallable( () -> null)
                .doOnNext(a -> System.out.println("onNext"))
                .doOnError(error -> System.out.println(error.getMessage()))
                .subscribe((a) -> System.out.println("onNext in subscrition"));
    }
}
