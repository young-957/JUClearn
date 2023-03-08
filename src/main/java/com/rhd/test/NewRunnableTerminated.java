package com.rhd.test;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/25 21:09
 * @Project_name JUClearn
 * @Version 1.0
 */
public class NewRunnableTerminated implements  Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        //打印出NEW的状态
        System.out.println("New?: "+thread.getState());
        thread.start();
        System.out.println("Runnable?: "+thread.getState());
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出RUNNABLE的状态，即使是正在运行，也是RUNNABLE，而不是RUNNING
        System.out.println("Runnable?: "+thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出TERMINATED状态
        System.out.println("Terminated?: "+thread.getState());

    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            double f = Math.random() / 5;
        }
    }
}
