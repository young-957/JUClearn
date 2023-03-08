package com.rhd.test.threadobjectclasscommonmethods;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/25 22:25
 * @Project_name JUClearn
 * @Version 1.0
 */
public class WaitNotifyReleaseOwnMonitor {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("ThreadA got resourceA lock.");
                    synchronized (resourceB) {
                        System.out.println("ThreadA got resourceB lock.");
                        try {
                            System.out.println("ThreadA releases resourceA lock.");
                            //这里只会释放resourceA的monitor锁，跟resourceB没关系
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    System.out.println("ThreadB got resourceA lock.");
                    System.out.println("ThreadB tries to resourceB lock.");
                    //由于线程A没有释放resourceB，这里也进不去
                    synchronized (resourceB) {
                        System.out.println("ThreadB got resourceB lock.");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
