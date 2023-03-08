package com.rhd.test.threadobjectclasscommonmethods;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/25 22:04
 * @Project_name JUClearn
 * @Version 1.0
 */
public class WaitNotifyAll implements Runnable{
    private static final Object resourceA = new Object();

    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName()+" got resourceA lock.");
            try {
                System.out.println(Thread.currentThread().getName()+" waits to start.");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName()+"'s waiting to end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        WaitNotifyAll r = new WaitNotifyAll();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        Thread threadc = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
//                    resourceA.notify();
                    resourceA.notifyAll();
                }
                System.out.println("ThreadC notified.");
            }
        });
        thread1.start();
        thread2.start();
//        Thread.sleep(1000);//如果不休眠，线程2拿到资源之前就线程c就已经唤醒线程a了，没有人去唤醒线程b。
        threadc.start();

    }


}
