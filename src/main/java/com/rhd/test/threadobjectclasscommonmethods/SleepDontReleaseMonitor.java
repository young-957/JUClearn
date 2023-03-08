package com.rhd.test.threadobjectclasscommonmethods;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/3/2 21:41
 * @Project_name JUClearn
 * @Version 1.0
 */

/**
 * sleep方法不释放锁包括<font color=greem>synchronized</font>和<font color=greem>lock</font>
 */
public class SleepDontReleaseMonitor implements Runnable{
    public static void main(String[] args) {
        SleepDontReleaseMonitor sleepDontReleaseMonitor = new SleepDontReleaseMonitor();
        new Thread(sleepDontReleaseMonitor).start();
        new Thread(sleepDontReleaseMonitor).start();
    }


    @Override
    public  void run(){
        syn();
    }

    private  synchronized void syn(){
        System.out.println("线程" + Thread.currentThread().getName() + "获得了monitor");
        try {
            Thread.sleep(5000);
            wait();
        }catch (InterruptedException e){
        e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName() + "退出了同步代码块");
    }
}
