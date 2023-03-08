package com.rhd.test.threadobjectclasscommonmethods;

/**
 * @Author RHD
 * @Description TODO
 * * 展示wait和notify的基本用法
 *  * 1. 研究代码执行顺序
 *  * 2. 证明wait释放锁
 * @Date 2023/2/25 21:54
 * @Project_name JUClearn
 * @Version 1.0
 */
public class Wait {
    public static Object object = new Object();
    static class Thread1 extends Thread {

        @Override
        public void run() {
            //持有object的monitor，才可以进入
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "开始执行了");
                try {
                    //调用wait方法，释放掉持有的object锁，等待被其它线程notify唤醒
                    //被唤醒后，继续抢占object锁，抢占后，继续向下执行
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁。");
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            //持有object的monitor，才可以进入
            synchronized (object) {
                //唤醒其它某个wait在object对象上的线程，继续向下执行，执行完释放掉object锁
                object.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "调用了notify()");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        Thread.sleep(200);
        thread2.start();
    }

}
