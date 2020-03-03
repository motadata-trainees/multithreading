package com.multithreading.java;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Config {
    private static Map<String, Integer> data = new ConcurrentHashMap<>();
    private static Map<String,Integer> datacopy = new ConcurrentHashMap<>();
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    private static AtomicBoolean isShutDown = new AtomicBoolean(false);

    public static void fetch(){
        Yaml yaml = new Yaml();
        File folder = new File("/home/keya/Desktop/read.yml");
        InputStream file = null;
        try {
            file = new FileInputStream(folder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        data = yaml.load(file);
        /*String path = "/home/keya/Desktop/read.yml";
        data = yaml.load(new FileInputStream(new File(path)));*/
        System.out.println(data);
        datacopy.putAll(data);

    }
    public static ConcurrentHashMap<String,Integer> getData(){
        return new ConcurrentHashMap<>(data);
    }
    public static Integer Mapget(String key){
        return datacopy.get(key);
        }

    public static void queuePut(String key) {
        try {
        queue.put(key);}catch(Exception e){
            e.printStackTrace();
        }
    }
    public static String queueTake()  {
        try{
                return queue.take();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean getisShutDown() {
        return isShutDown.get();
    }

    public static void setisShutDown(Boolean value){
        isShutDown.set(value);
    }


}


