import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class GlobalConfig {
    public static HashMap<String, Integer> configuration = new HashMap<String, Integer>();
    public static HashMap<String, Integer> configlog = new HashMap<String, Integer>();
    public static BlockingQueue queue=new LinkedBlockingQueue();
    public static AtomicBoolean isShutdown=new AtomicBoolean(false);
    public static void store() throws FileNotFoundException {
        try {
            Yaml yml = new Yaml();
            String path = "/home/abhishek/IdeaProjects/MultiAssign2/samap.yml";
            configuration = yml.load(new FileInputStream(new File(path)));
            System.out.println("Records: ");
            System.out.println(configuration);
            configlog.putAll(configuration);
        }
        catch (FileNotFoundException f) {
            f.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static HashMap<String,Integer> getConfiguration()
    {
        return configlog;
    }
    public static Integer getvalu(String key){

        return configuration.get(key);
    }
    public static boolean getState()
    {
        return isShutdown.get();
    }
    public static String getkey(Map.Entry<String,Integer> local)
    {
        return local.getKey();
    }
    public static Integer getvalue(Map.Entry<String,Integer> local)
    {
        return local.getValue();
    }
    public static void send(String key){
        try{
            queue.put(key);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static String receive() {
        String ip = null;
        try {
            ip = (String) queue.take();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e);
        }
        return ip;
    }
}