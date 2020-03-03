import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public class Addition  implements Runnable {


    public void run() {
        try {
                while (!ConfigurationManager.GetState()) {
                    for (HashMap.Entry<String, Integer> collector : ConfigurationManager.concurrentHashMap.entrySet()) {

                            int add = 10;
                            add = add + ConfigurationManager.IteratorGetValue(collector);
                            collector.setValue(add);
                            ConfigurationManager.AddQueue(add);


                        }
                    }
        } catch (Exception e){
            e.printStackTrace();
        }
    finally {
            if(!ConfigurationManager.GetState()){
                run();
            }
        }
    }
}