package com.rhd.test.threadobjectclasscommonmethods.线程异常处理;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/3/6 22:26
 * @Project_name JUClearn
 * @Version 1.0
 */
public class UseOwnUncaughtExceptionHandler implements Runnable{

    public static void main(String[] args) throws InterruptedException{
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "MyThread-4").start();
    }
    @Override
    public void run() {
     throw new RuntimeException();
    }
}
