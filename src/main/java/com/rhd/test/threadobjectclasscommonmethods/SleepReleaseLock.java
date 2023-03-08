package com.rhd.test.threadobjectclasscommonmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/3/2 21:50
 * @Project_name JUClearn
 * @Version 1.0
 */
public class SleepReleaseLock implements Runnable{
    private static final Lock lock = new ReentrantLock();
    @Override
    public  void run(){
        syn();
    }

    private  void syn(){
        lock.lock();
        System.out.println("线程" + Thread.currentThread().getName() + "获得了monitor");
        try {
            Thread.sleep(2000);
            System.out.println("线程" + Thread.currentThread().getName() + "获得了monitor");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        System.out.println("线程" + Thread.currentThread().getName() + "退出了同步代码块");
    }

    public static void main(String[] args) {
        SleepReleaseLock sleepReleaseLock = new SleepReleaseLock();
        new Thread(sleepReleaseLock).start();
        new Thread(sleepReleaseLock).start();
    }
}
