package com.rhd.test.threadobjectclasscommonmethods;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/3/2 22:29
 * @Project_name JUClearn
 * @Version 1.0
 */
public class JoinInterrupt {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mainThread.interrupt();
                    Thread.sleep(5000);
                    System.out.println("Thread1 finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("子线程中断");
                }
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕");

        try {
            //这里是主线程在join期间如果被interrupt，则抛出异常，跟thread1没有关系
            //如果thread1被中断，从而停止了运行，那也是运行完毕，thread1.join等待结束
            thread1.join();//中断了主线程
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName()+"的状态时" + Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName()+"主线程中断了");
            thread1.interrupt();
        }
        System.out.println("子线程已运行完毕");

    }
}
