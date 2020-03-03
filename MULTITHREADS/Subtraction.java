package com.multiplethreads.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Subtraction extends Thread{
    public void run() {

        try {

            while (!Config.getisShutDown()) {
                String key = Config.queue3Take();
                if(key!=null) {
                    Config.subtraction(key, 10);
                    Config.queue4Put(key);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!Config.getisShutDown())
                run();


        }

    }}