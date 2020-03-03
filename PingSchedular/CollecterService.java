package MultiThreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by parth on 23/2/20.
 */
public class CollecterService extends Thread {

    public void run()
    {
        try {
            while (!GlobalConfigure.getRunnable()) {

                String item = GlobalConfigure.getSharedQueueData();
                System.out.println(getName() + " [ Pinging  " + item + " ]");
                ping(item);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void ping(String ipAddress)  {
        System.out.println("Entered Ping");
        System.out.println("[ Pinging " + ipAddress + " ]");
        String[] command = {"/bin/bash","-c","ping -W 2 -t 2 -c 3 "+ipAddress};
        try{
            ProcessBuilder build = new ProcessBuilder(command);
            Process process = build.start();
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader Error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String s = null;
            System.out.println("output: ");
            while ((s = input.readLine()) != null) {
                System.out.println(s);
            }
            if ((s = Error.readLine()) != null) {
                while ((s = Error.readLine()) != null) {
                    System.out.println(s);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
