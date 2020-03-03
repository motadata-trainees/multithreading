import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GlobalConfiguration {

    //MEMBER VARIABLES
    public static Integer value=1;
    public static ArrayList<String> request=new ArrayList<String>();
    public static Lock lock=new ReentrantLock();
    public static BlockingQueue scheduleQueue = new LinkedBlockingQueue();
    public static HashMap<String, Integer> sources = new HashMap<String, Integer>();
    public static ConcurrentHashMap<String, Integer> services = new ConcurrentHashMap<String, Integer>();
    public static AtomicBoolean isShutdown = new AtomicBoolean(false);
    public static ExecutorService pool = Executors.newFixedThreadPool(2);


    //MEMBER FUNCTIONS
    public static Integer getvalu(String key) {
        return sources.get(key);
    }
    public static boolean gettState()
    {
        return isShutdown.get();
    }
    public static Set<Map.Entry<String,Integer>> entryset(ConcurrentHashMap<String,Integer> local){
        return local.entrySet();
    }
    public static String getkey(Map.Entry<String,Integer> local) {
        return local.getKey();
    }
    public static Integer getvalue(Map.Entry<String,Integer> local)
    {
        return local.getValue();
    }
    public static void store() {
        try {
            Yaml yml = new Yaml();
            String path = "/home/abhishek/IdeaProjects/MultiAssign5/src/main/samap.yml";
            sources = yml.load(new FileInputStream(new File(path)));
            System.out.println("Records: ");
            System.out.println(sources);
            services.putAll(sources);

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void randomTaskGenerator() {
        try {
            for (Map.Entry<String, Integer> entry : services.entrySet()) {
                entry.setValue(entry.getValue() - 10);
                if (entry.getValue() == 0) {
                    sendQueueOne(entry.getKey());
                    entry.setValue(getvalu(getkey(entry)));
                }
            }
            Thread.sleep(10);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    //FOR QUEUE 1
    public static void sendQueueOne(String key){
        try{
            scheduleQueue.put(key);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String receiveQueueOne(){
        String key=null;
        try{
            key= (String) scheduleQueue.take();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }
    public static Integer addition()
    {
        lock.lock();
        Integer add = 0;
        value=value+1;
        add=value;
        lock.unlock();
        return add;
    }
    public static Integer subtraction()
    {
        lock.lock();
        Integer sub = 0;
        value=value-1;
        sub=value;
        lock.unlock();
        return sub;
    }
    public static Integer multiplication()
    {
        lock.lock();
        Integer multiply = 1;
        value=value*2;
        multiply=value;
        lock.unlock();
        return multiply;
    }
    public static void execute(FutureTask task)
    {
        try {

            pool.execute(new Thread(task));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
}


