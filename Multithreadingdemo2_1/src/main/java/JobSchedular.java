import java.util.*;
import java.lang.Thread;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;


public class JobSchedular extends Thread
{


    public void run() {
        try {
            System.out.println("Entered the schedular Thread");
            while (!Configuration.isShutdownGet()) {
                        String task = Configuration.taketask6();
                        if(task!=null)
                        Configuration.requestCollector(task);

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
