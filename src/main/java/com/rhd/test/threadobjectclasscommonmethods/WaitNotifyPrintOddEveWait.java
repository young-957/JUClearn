package com.rhd.test.threadobjectclasscommonmethods;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/25 22:53
 * @Project_name JUClearn
 * @Version 1.0
 */
public class WaitNotifyPrintOddEveWait {
    private static int count = 0;
    private static final Object lock = new Object();


    public static void main(String[] args) {
        new Thread(new TurningRunner(), "偶数").start();
        new Thread(new TurningRunner(), "奇数").start();
    }

    //1. 拿到锁，我们就打印
    //2. 打印完，唤醒其他线程，自己就休眠
    //同步静态代码块包裹，保证等待和唤醒只有一个在执行
    static class TurningRunner implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    lock.notify(); //唤醒线程，但不解锁
                    //先通知再wait，否则两个线程都wait，造成死锁了。
                    if (count <= 100) {
                        try {
                            //如果任务还没结束，就让出当前的锁，并休眠
                            lock.wait();
                            System.out.println("1");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
