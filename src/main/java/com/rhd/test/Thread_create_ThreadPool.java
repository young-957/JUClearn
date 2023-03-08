package com.rhd.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/22 22:37
 * @Project_name JUClearn
 * @Version 1.0
 */
public class Thread_create_ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Task() {
            });
        }
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
