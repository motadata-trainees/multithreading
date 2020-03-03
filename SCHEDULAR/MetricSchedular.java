package com.multithreading.java;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MetricSchedular extends Thread {

    public void run() {
        try {
            System.out.println("Entered the schedular Thread");

            long currentTime = System.currentTimeMillis();
            ConcurrentHashMap<String,Integer> data= Config.getData();


            while (!Config.getisShutDown()) {
                Thread.sleep(10000);
                for (HashMap.Entry<String, Integer> entry : data.entrySet()) {
                    if (entry.getValue() > 0)
                        entry.setValue(entry.getValue() - 10);
                        if(entry.getValue() == 0){
                        currentTime = System.currentTimeMillis() - currentTime;
                        System.out.println(currentTime/1000);
                        currentTime = System.currentTimeMillis();
                        Config.queuePut(entry.getKey());
                        entry.setValue(Config.Mapget(entry.getKey()));}

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


