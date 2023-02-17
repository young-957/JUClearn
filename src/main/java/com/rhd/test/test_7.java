package com.rhd.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/17 11:11
 * @Project_name juc
 * @Version 1.0
 */
@Slf4j(topic = "c.ThreadStarter")
public class test_7 {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("enter sleep...");
                try {
                    Thread.sleep(2000);
                    System.out.println("不会执行");
                } catch (InterruptedException e) {
                    log.debug("wake up...");
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        Thread.sleep(1000);
        log.debug("interrupt...");
        t1.interrupt();
    }
}

