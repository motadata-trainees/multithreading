package com.multithreading.java;

import java.io.FileNotFoundException;

public class BootManager {
    public static void main(String args[]) {
        Config.fetch();
        MetricSchedular metricScheduler = new MetricSchedular();
        CollectionService collectionService = new CollectionService();
        try {
            metricScheduler.start();
            collectionService.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
