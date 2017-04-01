package com.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by pc5 on 2017/3/27.
 */
public class Person implements Runnable{

    private Car car;

    private String name;

    public Person() {
        super();
    }

    public Person(Car car,String name) {
        this.car = car;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep((long)(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        car.getton(name);
    }

}