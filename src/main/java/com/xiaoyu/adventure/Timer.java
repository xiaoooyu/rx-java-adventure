package com.xiaoyu.adventure;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Timer {

    public static void main(String[] args) {
        Completable.timer(5, TimeUnit.SECONDS)
                .doOnComplete(() -> {
                    System.out.printf("com.xiaoyu.adventure.Timer doOnComplete, @%d\r\n", Thread.currentThread().getId());
                })
                .subscribe(() -> {
                    System.out.printf("com.xiaoyu.adventure.Timer onComplete, @%d\r\n", Thread.currentThread().getId());
                });

        System.out.printf("print after subscribe, @%d\r\n", Thread.currentThread().getId());

        Scanner scanner = new Scanner(System.in);
        String waitingInput = scanner.next();
    }
}
