import java.util.*;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;


public class JobSchedular extends Thread
{


    public void run() {
        try {
            System.out.println("Entered the schedular Thread");
            Configuration.getConfiguration();
            while (!Configuration.isShutdownGet()) {
                String task = Configuration.chooseRandom();
                if(task!=null) {
                    if (Configuration.checksInQueue(task)) {
                        Configuration.requestCollector(task);
                        Configuration.taketask6(task);

                    }
                }
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
