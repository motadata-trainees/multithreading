package com.multiplethreads.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Result extends Thread{
    public void run(){
        while(!Config.getisShutDown()){
            try {

                String key = Config.queue5Take();
                Config.result(key);
                Config.queue1Put(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
