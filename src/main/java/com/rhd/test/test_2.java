package com.rhd.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/17 11:17
 * @Project_name juc
 * @Version 1.0
 */
@Slf4j
public class test_2 {
    public static void main(String[] args) {
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                for (;;){
                    System.out.println("------>1 " + count++);
                }
            }
        };
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                for (;;){
                    Thread.yield();
                    System.out.println("------>2 " + count++);
                }
            }
        };

        Thread t1 = new Thread(task1, "t1");
        System.out.println(t1.getState());
        Thread t2 = new Thread(task2, "t2");
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
