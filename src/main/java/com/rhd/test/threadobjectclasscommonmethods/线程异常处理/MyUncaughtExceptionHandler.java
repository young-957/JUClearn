package com.rhd.test.threadobjectclasscommonmethods.线程异常处理;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author RHD
 * @Description TODO
 * @Date 2023/3/6 22:23
 * @Project_name JUClearn
 * @Version 1.0
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private String name;
    public MyUncaughtExceptionHandler(String name){
        this.name = name;
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING, "线程异常，终止啦" + t.getName());
        System.out.println(name + "捕获了异常" + t.getName() + "异常");
    }
}
