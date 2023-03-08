package com.rhd.test;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/2/23 21:01
 * @Project_name JUClearn
 * @Version 1.0
 */
public class RightWayStopThreadInProd implements Runnable{
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {//得不到中断信息
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  //传递中断，防止终端被吞掉
                //保存日志、停止程序
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }


    //如果此方法由其他人开发，我们只负责调用；如果开发人员在方法里面使用try catch把
    //异常吞掉那么会造成非常严重的后果，上面的调用便无法感知到该异常，即使while里面加了检测机制，
    //也没有办法正确处理中断信号
    private void throwInMethod() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(2000); //main函数中断
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
