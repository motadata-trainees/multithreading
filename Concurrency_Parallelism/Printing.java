import java.util.HashMap;

public class Printing implements Runnable {
    public void run() {
        try {
            while (!ConfigurationManager.GetState()) {
                for (HashMap.Entry<String, Integer> collector : ConfigurationManager.concurrentHashMap.entrySet()) {
                    System.out.println(ConfigurationManager.IteratorGetKey(collector) + " " + ConfigurationManager.PrintQueueTake());
                }
            }
            }catch(Exception e){
            e.printStackTrace();
            }
        finally {
            if(!ConfigurationManager.GetState()){
                run();
            }
        }
        }
    }
