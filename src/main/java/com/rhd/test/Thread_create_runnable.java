package com.rhd.test;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/22 22:20
 * @Project_name JUClearn
 * @Version 1.0
 */
public class Thread_create_runnable implements Runnable{
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void  run(){
                System.out.println("重写run方法");
            }
        }.start();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一种方式");
            }
        });
        thread.start();

        Thread method2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        }) {
            @Override
            public void run() {
                System.out.println("第二种方式");
            }
        };

        method2.start();

        Thread thread1 = new Thread(new Thread_create_runnable());
        thread1.start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();


    }


    @Override
    public void run() {
        System.out.println("a222");
    }
}
