package com.rhd.test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author RHD
 * @Description 定时器创建线程
 * @Date 2023/2/22 22:42
 * @Project_name JUClearn
 * @Version 1.0
 */
public class Thread_create_DemoTimmerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,2000);
    }
}
