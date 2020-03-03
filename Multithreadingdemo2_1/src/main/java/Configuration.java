import java.util.*;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Configuration{


    private static ConcurrentHashMap<String,Integer> configuration = new ConcurrentHashMap<>();
    private static BlockingQueue<String> collectorQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> addititonQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> substratctionQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> multiplicationQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> divisionQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> displayQueue = new LinkedBlockingQueue<String>();
    private static BlockingQueue<String> ReshceduleServiceQueue = new LinkedBlockingQueue<String>();
    private static AtomicBoolean isShutdown = new AtomicBoolean(false);
    public static void loadConfig() throws IOException {
        try {
            HashMap<String,Integer> localconfiguration = new HashMap<>();
            Yaml yaml = new Yaml();
            String path = "/home/ravi/Desktop/entries.yml";
            localconfiguration=yaml.load(new FileInputStream(new File(path)));
            configuration.putAll(localconfiguration);
            System.out.println(configuration);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
    public static int getConfigurationValue(String name)
    {
        int value=0;
        try {
            value = configuration.get(name);


        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            return value;

        }


    }
    public static void setConfigurationValue(String name,int value)
    {
            configuration.put(name,value);
    }

    public static void requestCollector(String task)
    {
        try {
                collectorQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
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
        catch (Exception exception)
        {
            exception.printStackTrace();
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


    public static String taketask6()
    {
        String task=null;

        try {
            task =
            ReshceduleServiceQueue.take();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return task;


    }
    public static void requestCollector1(String task)
    {
        try {
                addititonQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }


    public static String takeTask1()
    {
        String task = null;

        try {
            task = addititonQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return task;

    }
    public static void requestCollector2(String task)
    {
        try {
                substratctionQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }


    public static String takeTask2()
    {
        String task = null;

        try {
            task = substratctionQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
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
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }


    public static String takeTask3()
    {
        String task = null;

        try {
            task = multiplicationQueue.take();
        } catch (InterruptedException e) { e.printStackTrace();}

          catch (Exception exception)
            {
                exception.printStackTrace();
            }

        return task;

    }
    public static void requestCollector4(String task)
    {
        try {
                divisionQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String takeTask4()
    {
        String task = null;

        try {
            task = divisionQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return task;

    }
    public static void requestCollector5(String task)
    {
        try {
                displayQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

    }


    public static String takeTask5()
    {
        String task = null;

        try {
            task = displayQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return task;

    }
    public static boolean isShutdownGet() {
        boolean getisShutdown = isShutdown.get();
        return getisShutdown;
    }
    public static void display(String name)
    {
        int value = getConfigurationValue(name);
        System.out.println(name+" : "+value);
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
    public static String getName(ConcurrentHashMap.Entry<String,Integer> entry)
    {
        String name = entry.getKey();
        return name;
    }
    public static int getvalue(ConcurrentHashMap.Entry<String,Integer> entry)
    {
        int value = entry.getValue();
        return value;
    }

}
