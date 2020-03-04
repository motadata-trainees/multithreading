package Scheduler;

//import java.io.IOException;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;

public class BootManager {
    public static void main(String args[])  {
        //   BlockingQueue<String> sharedQ = new LinkedBlockingQueue<String>();
      //  Config config = new Config();

            Config.getConfiguration();



        MetricScheduler Scheduler = new MetricScheduler();
        ServiceCall TaskForPinging = new ServiceCall();

        try {
            Scheduler.start();
            TaskForPinging.start();
        }
        
        catch(RuntimeException re)
        {
            re.printStackTrace();
        }

        catch (Exception e)
        {
            e.getMessage();
        }
    }
}
