package com.multiplethreads.java;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Multiplication extends Thread {

    public void run() {

            try {
                while (!Config.getisShutDown()) {

                String key = Config.queue2Take();
                if(key!=null) {
                    Config.multiplication(key, 5);
                    Config.queue3Put(key);
                }
            }
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (!Config.getisShutDown())
                    run();



    }
}
}



