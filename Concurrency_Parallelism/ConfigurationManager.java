import org.w3c.dom.ls.LSOutput;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.FileInputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;


public class ConfigurationManager
{
    public static HashMap<String,Integer> hashMap=new HashMap<String, Integer>();
    public static ConcurrentHashMap<String,Integer> concurrentHashMap=new ConcurrentHashMap<>();

    public static AtomicBoolean isNotReady= new AtomicBoolean(false);

    public static LinkedBlockingQueue<Integer> linkedBlockingQueue1=new LinkedBlockingQueue();
    public static LinkedBlockingQueue<Integer> linkedBlockingQueue2=new LinkedBlockingQueue();
    public static LinkedBlockingQueue<Integer> linkedBlockingQueue3=new LinkedBlockingQueue();
    public static LinkedBlockingQueue<Integer> linkedBlockingQueue4=new LinkedBlockingQueue();


    public static void AddQueue(Integer i) {
        linkedBlockingQueue1.add(i);
    }

    public static Integer SubQueueTake() {
        int Sub=0;
        try {
            Sub=linkedBlockingQueue1.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Sub;
    }

    public static void SubQueue(Integer i) {
        linkedBlockingQueue2.add(i);
    }

    public static Integer MulQueueTake() {
        int Mul=0;
        try {
            Mul=linkedBlockingQueue2.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Mul;
    }

    public static void MulQueue(Integer i) {
        linkedBlockingQueue3.add(i);
    }

    public static Integer DivQueueTake() {
        int Div=0;
        try {
            Div=linkedBlockingQueue3.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Div;
    }

    public static void DivQueue(Integer i) {
        linkedBlockingQueue4.add(i);
    }

    public static Integer PrintQueueTake() {
        int Print=0;
        try {
            Print=linkedBlockingQueue4.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Print;
    }

    public static void fetch() throws IOException{
        try{
        Yaml yaml = new Yaml();
        hashMap = yaml.load(new FileInputStream(new File("/home/satvik/Downloads/multi2.yaml")));
        concurrentHashMap.putAll(hashMap);
        System.out.println(concurrentHashMap);
    }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean GetState(){
        return isNotReady.get();
    }
    public static void  SetState(boolean state){
        isNotReady.set(state);
    }
    public static Integer IteratorGetValue(HashMap.Entry<String, Integer> collector){
        return collector.getValue();
    }
    public static String IteratorGetKey (HashMap.Entry<String, Integer> collector){
        return collector.getKey();
    }
}
