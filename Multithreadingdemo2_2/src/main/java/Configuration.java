import java.util.*;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Configuration{


    private static HashMap<String,Integer> configuration = new HashMap<>();
    private static ArrayList<String> configList = new ArrayList<>();
    private static BlockingQueue<String> collectorQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> additionQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> substractionQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> multiplicationQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> modulousQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> divisionQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> ReshceduleServiceQueue = new LinkedBlockingQueue<String>();
    private static Lock lock = new ReentrantLock();
    static AtomicBoolean isShutdown = new AtomicBoolean(false);
    public static void loadConfig() throws IOException {
        try {
            Yaml yaml = new Yaml();
            String path = "/home/ravi/Desktop/entries.yml";
            configuration=yaml.load(new FileInputStream(new File(path)));
            System.out.println(configuration);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static  void getConfiguration()
    {
        for (HashMap.Entry<String, Integer> entry : configuration.entrySet())
        {
            configList.add(entry.getKey());
        }
    }
    public static int getConfigurationValue(String name)
    {
        lock.lock();
        int value=0;
        try {
            value = configuration.get(name);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
            return value;

        }


    }
    public static void setConfigurationValue(String name,int value)
    {
        lock.lock();

        try
        {
            configuration.put(name,value);
        }
        finally
        {
            lock.unlock();
        }

    }

    public static void requestCollector(String task)
    {
        try {
                collectorQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String takeTask()
    {
        String task = null;

        try {
            task = collectorQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task;

    }
    public static void requestCollector6(String task)
    {
        try {
            ReshceduleServiceQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void taketask6(String name)
    {

        try {
            ReshceduleServiceQueue.remove(name);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void requestCollector1(String task)
    {
        try {
                additionQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String takeTask1()
    {
        String task = null;

        try {
            task = additionQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task;

    }
    public static void requestCollector2(String task)
    {
        try {
                substractionQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String takeTask2()
    {
        String task = null;

        try {
            task = substractionQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task;

    }
    public static void requestCollector3(String task)
    {
        try {
                multiplicationQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String takeTask3()
    {
        String task = null;

        try {
            task = multiplicationQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task;

    }
    public static void requestCollector4(String task)
    {
        try {
                modulousQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String takeTask4()
    {
        String task = null;

        try {
            task = modulousQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task;

    }
    public static void requestCollector5(String task)
    {
        try {
                divisionQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String takeTask5()
    {
        String task = null;

        try {
            task = divisionQueue.take();
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
    public static void display(String name)
    {
        lock.lock();
        int value = getConfigurationValue(name);
        System.out.println(name+" : "+value);
        lock.unlock();
    }
    public static void initialzeReshedular()
    {
        for (HashMap.Entry<String, Integer> entry : Configuration.configuration.entrySet()) {

            Configuration.requestCollector6(entry.getKey());
            //Thread.sleep(1000);
        }
    }
    public static boolean checksInQueue(String name)
    {
        boolean value = Configuration.ReshceduleServiceQueue.contains(name);
        return value;
    }
    public static String chooseRandom()
    {
        String task = null;
        int randomIndex = (int) (Math.random() * (configList.size()));
        task=configList.get( randomIndex );
        return task;
    }

}
