package Scheduler;

import java.util.*;
import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServiceCall extends Thread {
    //public static BlockingQueue<String> sharedQueue=new LinkedBlockingQueue<String>() ;

   /* public ServiceCall(BlockingQueue<String> aQueue) {
        super("ServiceCall");
        this.sharedQueue = aQueue;
    }*/


    public  void run()
    {
        try {
            while (!Config.getIsRunning()) {
                String item = MetricScheduler.getSharedQueue();
                System.out.println(getName() + " [ Pinging  " + item+" ]");
                try {
                    ping(item);
                }
                catch (Exception e)
                {
                    e.printStackTrace();;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            //Config.isShutDown.set(false);
        }
        finally {
           // setIsRunning(true,false);
            if(!Config.getIsRunning())
            {
              run();
            }

        }
    }
    public void ping(String ipAddress)
    {
        System.out.println("Entered For Pinging");
        System.out.println("[ Pinging "+ipAddress+ " ]");
        String [] command  = {"/bin/bash", "-c","ping -i 2 -t 2 -c 4 "+ipAddress};
        ProcessBuilder build = new ProcessBuilder(command);
        try {
            Process process = build.start();

            BufferedReader input = new BufferedReader(new InputStreamReader
                    (process.getInputStream()));
            BufferedReader Error = new BufferedReader(new InputStreamReader
                    (process.getErrorStream()));
            String s = null;
            System.out.println("Standard output: ");
            while ((s = input.readLine()) != null) {
                System.out.println(s);
            }
            if ((s = Error.readLine()) != null) {
                while ((s = Error.readLine()) != null) {
                    System.out.println(s);
                }
            }
        }
        catch (UnknownHostException uhE)
        {
          uhE.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}