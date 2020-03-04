package Scheduler;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Config {
    private static HashMap<String, Integer> relog = new HashMap<>();

    private static HashMap<String, Integer> log = new HashMap<>();
                                                                            //public static BlockingDeque<String> sharedQueueData=new LinkedBlockingDeque<>();
    public static void setSharedQueue(BlockingQueue<String> sharedQueue) {
        Config.sharedQueue = sharedQueue;
    }

    private static BlockingQueue<String> sharedQueue=new LinkedBlockingQueue<String>() ;

    private static AtomicBoolean isShutDown=new AtomicBoolean(false);

    public static HashMap<String, Integer> getRelog() {
        return relog;
    }

    public static void setRelog(HashMap<String, Integer> relog) {
        Config.relog = relog;
    }

    public static HashMap<String, Integer> getLog() {
        return log;
    }


    public static BlockingQueue<String> getSharedQueue() {
        return sharedQueue;

    }

    public static void setLog(HashMap<String, Integer> log) {
        Config.log = log;
    }


    public static Boolean getIsRunning() {
        return isShutDown.get();
    }


    public static void setIsShutDown(Boolean isRunning) {
        Config.isShutDown.set( isRunning);
    }

    public static void getConfiguration() {
        Yaml yaml = new Yaml();
        String path = "/home/nilesh/Desktop/test.yaml";
        try {
            log = yaml.load(new FileInputStream(new File(path)));
            System.out.println(log);
            setRelog(log);
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }
}