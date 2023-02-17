package com.rhd.test;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/17 11:45
 * @Project_name juc
 * @Version 1.0
 */
@Slf4j(topic = "c.Test10")
public class test_10 {
    static int r = 0;
    public static void main(String[] args) throws InterruptedException {
        test1();
    }
    private static void test1() throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            log.debug("开始");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("结束");
            r = 10;
        },"t1");
        t1.start();
//        t1.join();
        log.debug("结果为:{}", r); //占位符
        log.debug("结束");
    }
}