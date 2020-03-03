package com.multiplethreads.java;

import java.security.Key;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Division extends Thread {
   // Lock lock = new ReentrantLock();
    public void run(){

        try {
            while (!Config.getisShutDown()) {
                String key = Config.queue4Take();
                if(key!=null) {
                    Config.division(key, 2);
                    Config.queue5Put(key);
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
