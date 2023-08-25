package com.xiaoyu.avance.multithread;

public class ThreadGettingStart extends java.lang.Thread {
    @Override
    public void run() {
        System.out.println("Commence de thread personalisé");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Fin de thread personalisé");
    }
}
