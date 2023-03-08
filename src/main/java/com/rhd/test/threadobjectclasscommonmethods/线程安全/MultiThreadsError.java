package com.rhd.test.threadobjectclasscommonmethods.线程安全;

/**
 * @Author RHD
 * @Description TODO- 第一种：运行结果出错。
 *
 * - 演示计数不准确（减少），找出具体出错的位置。
 * @Date 2023/3/8 10:05
 * @Project_name JUClearn
 * @Version 1.0
 */
public class MultiThreadsError implements Runnable{

    public static void main(String[] args) throws InterruptedException{
        MultiThreadsError multiThreadsError = new MultiThreadsError();
        Thread thread1 = new Thread(multiThreadsError);
        Thread thread2 = new Thread(multiThreadsError);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("表面上结果是： " + multiThreadsError.index);
    }

    static int index = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            index++;
        }
    }
}
