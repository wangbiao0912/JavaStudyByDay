package com.jdk;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *jdk8的新特性和python比较
 * Created by pc5 on 2017/3/22.
 */
public class lambda {
    /**
     * jdk8 之前线程实现方式
     */
    @Test
    public void theread_before()
    {
        System.out.print("11111");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("线程启动了" );
                try{
                    Thread.sleep(1000);
                }catch (Exception e)
                {
                    System.out.print(e.getMessage());
                }
                System.out.print("线程跑完了");
            }
        }).start();
    }

    /**
     * 线程之后的新语法
     */
    @Test
    public void thread_afther(){
        System.out.println("11111");
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
        new Thread(
                () -> {System.out.print("///////////////////");
                try {
                    Thread.sleep(1000);
                }catch (Exception E)
                {
                    System.out.print("/....");
                }}
        ).start();
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !000000!") ).start();
        new Thread( () -> System.out.println("////////////////00000///")).start();
    }


    /**
     * 表达式进行事件处理
     */
    @Test
    public  void swingMessage(){
        // Java 8之前：
        JButton show =  new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
        // Java 8方式：
        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });
    }


}
