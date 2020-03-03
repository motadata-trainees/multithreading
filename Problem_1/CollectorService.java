import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CollectorService extends Thread {
    private BufferedReader input;
    private BufferedReader error;
    public void run()
    {
        try {
            while (!(GlobalConfig.getState())) {
                String address = GlobalConfig.receive();
                System.out.println(" [ Pinging  " + address + " ]");
                connect(address);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(!(GlobalConfig.getState()))
            {
                run();
            }
        }
    }
    public void connect(String ip) throws IOException {
        try {
            String[] command = {"/bin/bash", "-c", "ping -i 2 -W 2 -t 2 -c 2 " + ip};
            ProcessBuilder build = new ProcessBuilder(command);
            Process process = build.start();
            input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String output = null;
            System.out.println("Output : ");
            while ((output = input.readLine()) != null) {
                System.out.println(output);
            }
            if ((output = error.readLine()) != null) {
                System.out.println("Error, if any: ");
                while ((output = error.readLine()) != null) {
                    System.out.println(output);
                }
            }
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            input.close();
            error.close();
        }
    }
}