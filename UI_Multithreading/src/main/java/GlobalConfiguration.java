import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;



public class GlobalConfiguration {
    private static ConcurrentHashMap<String,Integer> configuration = new ConcurrentHashMap<String,Integer>();
    private static String[] name = {"LineGraph","Histogram","BarGraph","FrequencyTable"};
    private static BlockingQueue<String> taskPool = new LinkedBlockingQueue<String>();
    static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    private static AtomicBoolean isShutdown = new AtomicBoolean(false);
    public static int getConfiguration(String name)
    {
        return configuration.get(name);

    }
    public static void setconfiguration(String name,int value)
    {
        configuration.put(name,value);
    }
    public static void initializeConfiguration()
    {
        int value = 0;
        for(int i =0;i<4;i++)
        {
            value=+10;
            configuration.put(name[i],value);
        }
    }
    public static void executeTask()
    {

        Future<String> futureTask = null;
        String task=null;
        for (int i=0; i<15; i++)
        {
            task = fetchTask();
            if(task.equals("BarGraph")) {
                BarGraphExecutor barGraphExecutor = new BarGraphExecutor(task);
                futureTask = executor.submit(barGraphExecutor);
            }
            else if(task.equals("Histogram")) {
               HistogramExecutor histogramExecutor = new HistogramExecutor(task);
               futureTask = executor.submit(histogramExecutor);
            }
            else if(task.equals("FrequencyTable")) {
                FrequencyTableExecutor frequencyTableExecutor = new FrequencyTableExecutor(task);
                futureTask = executor.submit(frequencyTableExecutor);
            }
            else if(task.equals("LineGraph")) {
                LineGraphExecutor lineGraphExecutor = new LineGraphExecutor(task);
                futureTask = executor.submit(lineGraphExecutor);
            }
            else
                System.out.println("invalid Command");
            try
            {
                System.out.println(futureTask.get() +" is closed\n");
            }
            catch (InterruptedException exception)
            {
                exception.printStackTrace();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }
    public static boolean isShutdownGet()
    {
        boolean getisShutdown=isShutdown.get();
        return getisShutdown;
    }
    public static String fetchTask()
    {
        String task = null;

        try {
            task = taskPool.take().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task;

    }
    public static void submitTask(String task)
    {
        try {
            taskPool.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static String getTask(){
        Random r=new Random();
        int randomNumber=r.nextInt(name.length);
        return name[randomNumber];
    }

}
