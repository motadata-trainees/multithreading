package Scheduler;

import java.util.*;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



class MetricScheduler extends Thread
{
    public static String getSharedQueue() {
        String str="Ip not Get from File";
        try{
            str= Config.getSharedQueue().take();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return str;
    }




    public void run() {
        //   boolean isRunnable = true;
        try {
            System.out.println("Entered the scheduler Thread");

            while (!Config.getIsRunning()) {

               // System.out.println(System.currentTimeMillis());
                for (HashMap.Entry<String, Integer> entry : Config.getLog().entrySet()) {
                    if (entry.getValue() > 0)
                    {  entry.setValue(entry.getValue() - 10);

                           // System.out.println(entry.getValue());
                        }
                    else {
                        Config.getSharedQueue().put(entry.getKey());
                        entry.setValue(Config.getRelog().get(entry.getKey()));
                    }
                    Thread.sleep(10000);
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}