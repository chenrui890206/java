package com.ray.employee;

import cn.hutool.http.HttpUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Concurrent {

    public static void concurrent() {

        int currency = 20;

        CyclicBarrier cb = new CyclicBarrier(currency);
        for (int i = 0; i < currency; i++) {
            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName()+"准备好了！");
                try {
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                HttpUtil.createGet("http://localhost:8080/employee/delete").execute().body();
            }).start();
        }
    }

    public static void main(String[] args) {
        concurrent();
    }
}
