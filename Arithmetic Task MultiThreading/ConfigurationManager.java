import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by nilesh on 24/2/20.
 */
public class ConfigurationManager {
    private static Map<String,Integer> ConfigData=new HashMap<>();

    private static AtomicBoolean isShutDown=new AtomicBoolean(false);

    private static BlockingQueue<String> valAddition=new LinkedBlockingQueue<>();
    private static BlockingQueue<String> valSubtraction=new LinkedBlockingQueue<>();
    private static BlockingQueue<String> valMultiplication=new LinkedBlockingQueue<>();
    private static BlockingQueue<String> valDivide=new LinkedBlockingQueue<>();
    private static BlockingQueue<String> valResult=new LinkedBlockingQueue<>();
    private static BlockingQueue<String> scheduler=new LinkedBlockingQueue<>();

    public static Map<String, Integer> getConfigData() {
        return ConfigData;
    }

    public static void putData(String key,int value)
    {
        ConfigData.put(key,value);
    }

    public static int getData(String name)
    {
        return ConfigData.get(name);
    }

    public static void setConfigData(Map<String, Integer> configData) {
        ConfigData = configData;
    }
    public static BlockingQueue<String> getScheduler() {
        return scheduler;
    }

   public static String takeAdditionTask() {
       String key = "";
       try {
           key=valAddition.take();
       } catch (InterruptedException e) {
           e.getMessage();

       }
       return key;
   }
    public static String takeSubtractionTask() {
        String key = "";
        try {
            key= valSubtraction.take();
        } catch (InterruptedException IE) {
            IE.getMessage();

        }
        return key;
    }
    public static String takeMultiplicationTask() {
        String key = "";
        try {
            key= valMultiplication.take();
        } catch (InterruptedException IE) {
            IE.getMessage();

        }
        return key;
    }
    public static String takeDivideTask() {
        String key = "";
        try {
            key=valDivide.take();
        } catch (InterruptedException IE) {
            IE.getMessage();

        }
        return key;
    }
    public static String takeResultTask() {
        String key = "";
        try {
            key=valResult.take();
        } catch (InterruptedException IE) {
            IE.getMessage();

        }
        return key;
    }


    public static void setValSubtraction(String key)
    {
        try {
            valSubtraction.put(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setValMultiplication(String key)
    {
        try {
            valMultiplication.put(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setValDivide(String key)
    {
        try {
            valDivide.put(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setValAddition(String key)
    {
        try {
            valAddition.put(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setValResult(String key)
    {
        try {
            valResult.put(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static Boolean getIsRunning() {
        return isShutDown.get();
    }

    public static void getConfiguration()  //throws InterruptedException
    {
        System.out.println("The Data in Hash Map is ");

            ConfigData.put("Parth",5);
        ConfigData.put("Ravi",6);
        ConfigData.put("Satvik",7);
        System.out.println(ConfigData);

    }
    public static void setValueOfScheduler()
    {
        for (Map.Entry<String, Integer> entry : ConfigurationManager.getConfigData().entrySet()) {
            try {
                    scheduler.put(entry.getKey());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

       // setValAddition("parth");    valAddition.put("Parth");valAddition.put("Ravi");valAddition.put("Satvik");
    }



