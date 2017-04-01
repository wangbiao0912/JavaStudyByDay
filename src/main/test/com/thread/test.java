package com.thread;

import org.junit.Test;

/**
 * Created by pc5 on 2017/3/27.
 */
public class test {

    @Test
    public  void test1(){

        Car c = new Car(10);
        Thread thread = new Thread(c);
        thread.start();

        for(int i=1;i<=10;i++){
            Person p = new Person(c, "屌丝"+i);
            Thread t = new Thread(p);
            t.start();
        }

    }
}
