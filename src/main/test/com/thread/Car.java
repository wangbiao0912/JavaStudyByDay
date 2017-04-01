package com.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by pc5 on 2017/3/27.
 *
 *
 CountDownLatch:

 官方的解释为：一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。

 我们现在就把它理解为倒数计数器，什么是倒数计数器呢，通俗的理解就是这个计数器事先有一个初始计数，在这个计数减到0之前，所有的线程等待。

 最近公司有出去旅游，一个业务场景浮现在脑海：部门一共十个人出去旅游，必须10个人上车之后大巴才能开车，下面就来模拟这个上车的过程。
 */
public class Car implements Runnable{

    private CountDownLatch countDownLatch;

    public Car() {
        super();
    }

    public Car(int count) {
        this.countDownLatch = new CountDownLatch(count);
    }

    @Override
    public void run() {
        System.out.println("一共需要上车屌丝数："+countDownLatch.getCount());

        try {
            countDownLatch.await();
            System.out.println("屌丝全部上车了--->>>老司机准备开车了。。。。");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void getton(String name) {
        System.err.println(name+"上车");
        countDownLatch.countDown();
        System.err.println("还剩下"+countDownLatch.getCount()+"个屌丝没有上车");
    }

}