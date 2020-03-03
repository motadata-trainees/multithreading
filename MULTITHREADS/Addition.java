package com.multiplethreads.java;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Addition extends Thread {
    //Lock lock = new ReentrantLock();

    public void run() {
        try {
            while (!Config.getisShutDown()) {
                String key = Config.queue1Take();
                if(key !=null) {
                    Config.addition(key, 10);
                    Config.queue2Put(key);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!Config.getisShutDown())
                run();
        }
    }
}



