import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;


public class GlobalConfiguration {
    public static HashMap<String, Integer> configuration = new HashMap<String, Integer>();
    public static ConcurrentHashMap<String, Integer> configlog = new ConcurrentHashMap<String, Integer>();
    public static HashMap<String, Integer> schedulelog = new HashMap<String, Integer>();
    public static BlockingQueue scheduleQueue = new LinkedBlockingQueue();
    public static AtomicBoolean isShutdown = new AtomicBoolean(false);
    public static BlockingQueue additionQueue10 = new LinkedBlockingQueue();
    public static BlockingQueue additionQueue20 = new LinkedBlockingQueue();
    public static BlockingQueue additionQueue30 = new LinkedBlockingQueue();
    public static BlockingQueue additionQueue40 = new LinkedBlockingQueue();
    public static BlockingQueue controlQueue=new LinkedBlockingQueue();
    public static void store(){
        try {
            Yaml yml = new Yaml();
            String path = "/home/abhishek/IdeaProjects/MultiAssign/samap.yml";
            configuration = yml.load(new FileInputStream(new File(path)));
            System.out.println("Records: ");
            System.out.println(configuration);
            configlog.putAll(configuration);
            schedulelog.putAll(configuration);
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    public static synchronized void computation(String key,Integer amount)
    {
        try{
            for (Map.Entry<String, Integer> entry : entryset(configlog)) {
                if (getkey(entry)==key) {
                   add(key,getvalue(entry),amount);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void add(String key,Integer value,Integer amount){
        try {
            configlog.put(key, configlog.get(key) + amount);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static Integer getFinalValue(String key){
        return configlog.get(key);
    }

    public static Integer getvalu(String key) {
        return configuration.get(key);
    }
    public static boolean getState() {
        return isShutdown.get();
    }
    public static Set<Map.Entry<String,Integer>> entryset(ConcurrentHashMap<String,Integer> local){
        return local.entrySet();
    }
    public static String getkey(Map.Entry<String,Integer> local)
    {
        return local.getKey();
    }
    public static Integer getvalue(Map.Entry<String,Integer> local)
    {
        return local.getValue();
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
    //FOR QUEUE 2
    public static void sendQueueTwo(String key){
        try{
            additionQueue10.put(key);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String receiveQueueTwo(){
        String key=null;
        try{
            key= (String) additionQueue10.take();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }
    //FOR QUEUE 3
    public static void sendQueueThree(String key){
        try{
            additionQueue20.put(key);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String receiveQueueThree(){
        String key=null;
        try{
            key= (String) additionQueue20.take();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }
    //FOR QUEUE 4
    public static void sendQueueFour(String key){
        try{
            additionQueue30.put(key);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String receiveQueueFour(){
        String key=null;
        try{
            key= (String) additionQueue30.take();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }
    //FOR QUEUE 5
    public static void sendQueueFive(String key){
        try {
            additionQueue40.put(key);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String receiveQueueFive(){
        String key=null;
        try{
            key= (String) additionQueue40.take();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }
    //For Queue 6
    public static void sendQueueSix(String key){
        try {
            controlQueue.put(key);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void receiveQueueSix(String key){
        try{
            controlQueue.remove(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean available(String key)
    {
        return GlobalConfiguration.controlQueue.contains(key);
    }
    public static void loadConfiguration() throws InterruptedException {
        for (Map.Entry<String, Integer> entry : configlog.entrySet()) {
            controlQueue.put(entry.getKey());
        }
    }
    public static void randomTaskGenerator()
    {
        try{
            for (Map.Entry<String, Integer> entry : schedulelog.entrySet()) {
                entry.setValue(entry.getValue() - 10);
                if (entry.getValue() == 0) {
                    if(available(entry.getKey()))
                    {
                        sendQueueOne(entry.getKey());
                       receiveQueueSix(entry.getKey());
                    }
                    entry.setValue(getvalu(entry.getKey()));
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}