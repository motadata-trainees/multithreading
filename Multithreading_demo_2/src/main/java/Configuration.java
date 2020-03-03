import java.util.*;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Configuration{


    public static ConcurrentHashMap<String,Integer> configuration = new ConcurrentHashMap<>();
    public static BlockingQueue<String> collectorQueue = new LinkedBlockingQueue<String>();
    public static BlockingQueue<String> TaskPassServiceQueue_1 = new LinkedBlockingQueue<String>();
    public static BlockingQueue<String> TaskPassServiceQueue_2 = new LinkedBlockingQueue<String>();
    public static BlockingQueue<String> TaskPassServiceQueue_3 = new LinkedBlockingQueue<String>();
    public static BlockingQueue<String> TaskPassServiceQueue_4 = new LinkedBlockingQueue<String>();
    public static BlockingQueue<String> TaskPassServiceQueue_5 = new LinkedBlockingQueue<String>();
    public static BlockingQueue<String> TaskPassServiceQueue_6 = new LinkedBlockingQueue<String>();
    static AtomicBoolean isShutdown = new AtomicBoolean(false);
    public static void fetch() throws IOException {
        try {
            HashMap<String,Integer> entry = new HashMap<>();
            Yaml yaml = new Yaml();
            String path = "/home/ravi/Desktop/entries.yml";
            entry=yaml.load(new FileInputStream(new File(path)));
            configuration.putAll(entry);
            System.out.println(configuration);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static int GetTaskValue(String name)
    {
        int value= configuration.get(name);
        return value;
    }
    public static void SetTaskOutput(String name,int value)
    {   configuration.put(name,value);
    }
    public static void requestCollector(String task,BlockingQueue<String> queue)
    {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String takeTask(BlockingQueue<String> queue)
    {
        String task = null;

        try {
            task = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task;
    }
    public static boolean isShutdownGet()
    {
        boolean getisShutdown=isShutdown.get();
        return getisShutdown;
    }
    public static int GetConfiguration(HashMap <String,Integer> ConfigMap,String Key) {
        int getConfiguration = configuration.get(Key);
        return getConfiguration;
    }
    public static int Addition(String name,int value)
    {
        int number = GetTaskValue(name);
        number=number+value;
        SetTaskOutput(name,number);
        return number;
    }
    public static int Substraction(String name,int value)
    {
        int number = GetTaskValue(name);
        number=number-value;
        SetTaskOutput(name,number);
        return number;
    }
    public static int Multiplication(String name,int value)
    {
        int number = GetTaskValue(name);
        number=number*value;
        SetTaskOutput(name,number);
        return number;
    }
    public static int Division(String name,int value)
    {
        int number = GetTaskValue(name);
        number=number/value;
        SetTaskOutput(name,number);
        return number;
    }
    public static int Modulous(String name,int value)
    {
        int number = GetTaskValue(name);
        number=number%value;
       // System.out.println(number);
        SetTaskOutput(name,number);
        return number;
    }
    public static void Display(String name)
    {
        int value = GetTaskValue(name);
        System.out.println(name+" : "+value);
    }

}
