package com.rhd.test;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/23 21:14
 * @Project_name JUClearn
 * @Version 1.0
 */
public class RightWayStopThreadInProd2 implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted，程序运行结束");
                break;
            }
            //子线程中断后，传递给主线程，主线程也中断
            reInterrupt();
        }
    }

    private  void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName());

            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        RightWayStopThreadInProd2 rightWayStopThreadInProd2 = new RightWayStopThreadInProd2();

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
