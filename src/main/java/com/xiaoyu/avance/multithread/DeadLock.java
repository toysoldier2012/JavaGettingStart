package com.xiaoyu.avance.multithread;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock
{
    static ReentrantLock resource1 = new ReentrantLock();
    static ReentrantLock resource2 = new ReentrantLock();

    public static void deadLock() {
        new Thread(() -> {
            while (true) {
                resource1.lock();
                System.out.println(Thread.currentThread().getName() + ": locked resource1");
                resource2.lock();
                System.out.println(Thread.currentThread().getName() + ": locked resource2");
                resource2.unlock();
                resource1.unlock();
            }
        }, "deadLock-1").start();
        new Thread(() -> {
            while (true) {
                resource2.lock();
                System.out.println(Thread.currentThread().getName() + ": locked resource2");
                resource1.lock();
                System.out.println(Thread.currentThread().getName() + ": locked resource1");
                resource1.unlock();
                resource2.unlock();
            }
        }, "deadLock-2").start();
    }

}
