package com.rhd.test;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/22 22:34
 * @Project_name JUClearn
 * @Version 1.0
 */
public class Thread_create_extends_thread  extends Thread{
    public static void main(String[] args) {
        new Thread_create_extends_thread().start();
    }

    public void run(){
        System.out.println("重写run()");
    }
}
