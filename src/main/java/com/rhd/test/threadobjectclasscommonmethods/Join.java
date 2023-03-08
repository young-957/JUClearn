package com.rhd.test.threadobjectclasscommonmethods;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/3/2 22:16
 * @Project_name JUClearn
 * @Version 1.0
 */
/**
 * 演示join，注意语句输出顺序，会变化。
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });
        thread.start();
        thread1.start();
        System.out.println("开始等待子线程运行完毕");
        thread.join();
        thread1.join();
        System.out.println("所有子线程执行完毕");

    }



}