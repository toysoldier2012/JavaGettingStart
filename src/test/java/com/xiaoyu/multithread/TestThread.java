package com.xiaoyu.multithread;

import com.xiaoyu.multithread.DeadLock;
import org.junit.Test;

import java.time.LocalDateTime;

public class TestThread {
    @Test
    public void test1(){
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();

        thread1.start();
        thread2.start();

        System.out.println("主线程执行：" + LocalDateTime.now());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束：" + LocalDateTime.now());
    }

    @Test
    public void test2(){
        Thread t1 = new Thread(() -> {
            System.out.println("线程执行：" + LocalDateTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束：" + LocalDateTime.now());
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            System.out.println("线程执行：" + LocalDateTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程结束：" + LocalDateTime.now());
        });
        t2.start();

        System.out.println("主线程执行：" + LocalDateTime.now());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束：" + LocalDateTime.now());
    }

    @Test
    public void test3(){
        DeadLock.deadLock();
    }
}
