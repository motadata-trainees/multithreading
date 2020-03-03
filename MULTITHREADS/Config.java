package com.multiplethreads.java;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Config {
    private static Map<String, Integer> data = new ConcurrentHashMap<>();
    private static Map<String, Integer> datacopy = new ConcurrentHashMap<>();
    private static AtomicBoolean isShutDown = new AtomicBoolean(false);
    private static BlockingQueue<String> queue1 = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> queue2 = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> queue3 = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> queue4 = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> queue5 = new LinkedBlockingQueue<String>();

    public static void fetch()  {
        try {

            Yaml yaml = new Yaml();
            String path = "/home/keya/Desktop/math.yml";
            datacopy = yaml.load(new FileInputStream(new File(path)));
            data.putAll(datacopy);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String queue1Take()  {
        try{
            return queue1.take();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void queue1Put(String key) {
        try {
            queue1.put(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String queue2Take() {
        try{
            return queue2.take();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void queue2Put(String key) {
        try {
            queue2.put(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String queue3Take()  {
        try{
            return queue3.take();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void queue3Put(String key) {
        try {
            queue3.put(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String queue4Take()  {
        try{
            return queue4.take();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void queue4Put(String key) {
        try {
            queue4.put(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String queue5Take()  {
        try{
            return queue5.take();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void queue5Put(String key) {
        try {
            queue5.put(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void addition(String key, int value) {
        /*for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (entry.getKey() == key)
                entry.setValue(entry.getValue() + value);

        }*/
        int add = getValue(key) + value;
        data.put(key,add);
    }

    public static void multiplication(String key,int value){
        int mul = getValue(key) * value;
        mul = mul%2000;
        data.put(key,mul);

    }
    public static void subtraction(String key,int value){
        int sub = getValue(key) - value;
        data.put(key,sub);
    }
    public static void division(String key,int value){
        int div = getValue(key)/ value;
        data.put(key,div);


    }
    public static void result(String key){
        int result= getValue(key);
        System.out.println(key + ":" + result);

    }
    public static int getValue(String key){
        return (data.get(key));
    }
    public static Boolean getisShutDown() {
        return isShutDown.get();
    }

    public static void setisShutDown(Boolean value){
        isShutDown.set(value);
    }

    public static void initialize() {
        for (ConcurrentHashMap.Entry<String, Integer> entry : data.entrySet()){
            String keys = entry.getKey();
            System.out.println(entry.getValue());
            Config.queue1Put(keys);
        }
        System.out.println(queue1);
    }
}

