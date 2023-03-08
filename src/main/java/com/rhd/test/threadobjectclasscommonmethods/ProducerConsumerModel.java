package com.rhd.test.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.LinkedList;

/**
 * @Author RHD
 * @Description TODO
 *
 *  * 用wait/notify来实现生产者消费者模式，不使用BlockingQueue
 *
 * @Date 2023/2/25 23:20
 * @Project_name JUClearn
 * @Version 1.0
 */
public class ProducerConsumerModel {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
class Producer implements Runnable {
    private EventStorage storage;

    public Producer(
            EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.put();
        }
    }
}

class Consumer implements Runnable {

    private EventStorage storage;

    public Consumer(
            EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.take();
        }
    }
}

class EventStorage {

    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    public synchronized void put() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("仓库里有了" + storage.size() + "个产品。");
        notify();
    }
//    wait方法
//
//    wait是要释放对象锁，进入等待池。
//    既然是释放对象锁，那么肯定是先要获得锁。
//    所以wait必须要写在synchronized代码块中，否则会报异常。
//    public synchronized void take() {
//        while (storage.size() == 0) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("拿到了" + storage.poll() + "，现在仓库还剩下" + storage.size());
//        notify();
//    }
public  void take(){
        synchronized (this){
            while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了" + storage.poll() + "，现在仓库还剩下" + storage.size());
        notify();
        }
}
}