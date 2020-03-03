package com.multiplethreads.java;

import java.util.HashMap;

public class Schedular extends Thread {
    public void run(){
        try {
            Config.initialize();
           /* for (HashMap.Entry<String, Integer> entry : Config.data.entrySet()){
                String keys = entry.getKey();
                Config.queue1Put(keys);*/
            //System.out.println(Config.queue1);

        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
