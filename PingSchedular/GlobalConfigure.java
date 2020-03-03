package MultiThreading;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by parth on 23/2/20.
 */
public class GlobalConfigure {
    private static HashMap<String,Integer> partialdata= new HashMap<>();
    private static HashMap<String,Integer> data= new HashMap<>();
    private static BlockingQueue<String> sharedQueueData=new LinkedBlockingDeque<>();
    private static AtomicBoolean runnable=new AtomicBoolean(false);
    private static Lock lock=new ReentrantLock();
    public static Boolean getRunnable()
    {
        return runnable.get();
    }

    public static String getSharedQueueData(){
        try {
             return sharedQueueData.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void setSharedQueueData(String key){
        try {
            sharedQueueData.put(key);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static HashMap<String, Integer> getData() {

        lock.lock();
        try
        {
            return new HashMap<>(data);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            lock.unlock();
        }

        return null;
    }

    public static  Integer getPartialdata(String key) {
        return partialdata.get(key);
    }

    public static void fetch(){
        String path = "/home/parth/Downloads/abc.yml";
        try {
            Yaml yaml = new Yaml();
            data = yaml.load(new FileInputStream(new File(path)));
            System.out.println(data);
            partialdata.putAll(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
