package com.rhd.test.threadobjectclasscommonmethods;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/3/2 23:16
 * @Project_name JUClearn
 * @Version 1.0
 */
public class JoinPrinciple {

    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("mainThread的状态 " + mainThread.getState());
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        });


        thread.start();
        System.out.println("开始等待子线程运行完毕");
        synchronized (thread) {
            //调用wait方法，释放掉持有的object锁，等待被其它线程notify唤醒
            Thread.sleep(2000);
            System.out.println("nihao ");
//            thread.wait();
        }
        System.out.println("所有子线程执行完毕");
    }
}
