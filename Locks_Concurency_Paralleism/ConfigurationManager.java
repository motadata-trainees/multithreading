import org.w3c.dom.ls.LSOutput;
import org.yaml.snakeyaml.Yaml;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.FileInputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ConfigurationManager
{
    public static HashMap<String,Integer> ConfigMap=new HashMap<String, Integer>();
//    public static ConcurrentHashMap<String ,Integer> hashMap=new ConcurrentHashMap<>();
    public static HashMap<String,Integer> duplicatehashMap=new HashMap<>();

    public static AtomicBoolean isNotReady= new AtomicBoolean(false);
    public static LinkedBlockingQueue<String> linkedBlockingQueue1=new LinkedBlockingQueue();
    public static LinkedBlockingQueue<String> linkedBlockingQueue2=new LinkedBlockingQueue();
    public static LinkedBlockingQueue<String> linkedBlockingQueue3=new LinkedBlockingQueue();
    public static LinkedBlockingQueue<String> schedulerqueue=new LinkedBlockingQueue();
    public static LinkedBlockingQueue<String> PrintqueueAdd=new LinkedBlockingQueue();
    public static Lock lock=new ReentrantLock();


    public static String HashMapIterator (HashMap.Entry<String, Integer> collector){
        return collector.getKey();
    }



    public static void PrintQueueAddFirst(){
        for (HashMap.Entry<String, Integer> collector : ConfigurationManager.ConfigMap.entrySet()) {
            ConfigurationManager.PrintqueueAdd.add(collector.getKey());
        }
    }

    public static void SchedulerQueueAdd(String name) {
        schedulerqueue.add(name);
    }

    public static String AddQueueTake() {
        String Sub="";
        try {
            Sub=schedulerqueue.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Sub;
    }

    public static void AddQueue(String name) {
        linkedBlockingQueue1.add(name);
    }

    public static String SubQueueTake() {
        String Sub="";
        try {
            Sub=linkedBlockingQueue1.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Sub;
    }

    public static void SubQueue(String name) {
        linkedBlockingQueue2.add(name);
    }

    public static String MulQueueTake() {
        String Mul="";
        try {
            Mul=linkedBlockingQueue2.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Mul;
    }

    public static void MulQueue(String name) {
        linkedBlockingQueue3.add(name);
    }


    public static String PrintQueueTake() {
        String Print="";
        try {
            Print=linkedBlockingQueue3.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Print;
    }

    public static void PrintingQueue(String name) {
        PrintqueueAdd.add(name);
    }

    public static String SchedulerQueueTake() {
        String Sub="";
        try {
            Sub=PrintqueueAdd.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Sub;
    }




    public static void fetch() throws IOException{
        try{
            Yaml yaml = new Yaml();
            duplicatehashMap = yaml.load(new FileInputStream(new File("/home/satvik/Downloads/multi2.yaml")));
            ConfigMap.putAll(duplicatehashMap);
            System.out.println(ConfigMap);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean GetState(){
        return isNotReady.get();
    }

    public static void  SetState(boolean state){
        lock.lock();
        isNotReady.set(state);
        lock.unlock();
    }

    public static Integer hashget(String name){
        return ConfigMap.get(name);
    }

    public static void hashput(String name,Integer value){
        lock.lock();
        ConfigMap.put(name,value);
        lock.unlock();
    }

    public static boolean AddQueueContains(String name){
       return linkedBlockingQueue1.contains(name);
    }
    public static boolean SubQueueContains(String name){
        return linkedBlockingQueue1.contains(name);
    }
    public static boolean MulQueueContains(String name){
        return linkedBlockingQueue1.contains(name);
    }
    public static boolean PrintQueueCheck(String name){
        if(PrintqueueAdd.contains(name)){
            return true;
        }
        else {
            return false;
        }

}
    public static boolean EmptyPrinterQueueCheck(){
        if(PrintqueueAdd.isEmpty()){
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void RemoveFromPrint(String name){
        PrintqueueAdd.remove(name);

    }
}
