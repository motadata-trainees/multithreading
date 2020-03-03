import java.util.*;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;


public class JobSchedular extends Thread
{


    public void run() {
        try {
            System.out.println("Entered the schedular Thread");
            while (!Configuration.isShutdownGet()) {
                for (HashMap.Entry<String, Integer> entry : Configuration.configuration.entrySet()) {
                    Configuration.requestCollector(entry.getKey(),Configuration.collectorQueue);
                    //Thread.sleep(1000);
                }
                //Thread.sleep(1000);
               //Configuration.requestCollector("Ravi",Configuration.collectorQueue);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            if(!Configuration.isShutdownGet()){
                run();
            }
        }
    }

}
