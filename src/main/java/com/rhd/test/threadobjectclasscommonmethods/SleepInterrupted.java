package com.rhd.test.threadobjectclasscommonmethods;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/3/2 22:00
 * @Project_name JUClearn
 * @Version 1.0
 */

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 每1秒钟输出当前时间，被中断，观察。
 * Thread.sleep()
 * TimeUnit.SECONDS.sleep()
 */
public class SleepInterrupted implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepInterrupted());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000000; i++) {
            System.out.println(new Date());
            try {
                //更优雅的sleep方式
//                TimeUnit.HOURS.sleep(3);
//                TimeUnit.MINUTES.sleep(25);
                TimeUnit.SECONDS.sleep(1);
//                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("我被中断了！");
                e.printStackTrace();
            }
        }
    }
}