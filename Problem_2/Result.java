package exmaple;

import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by parth on 24/2/20.
 */
public class Result extends Thread {
    Lock lock=new ReentrantLock();

    public void run()
    {
        try {

            while (!ConfigureManager.shutDown()) {
                String task = ConfigureManager.takeResultTask();

                if(task != null)
                {
                    float value = ConfigureManager.getData(task);

                    System.out.println(task+" "+value);

                    ConfigureManager.setValAdd(task);

                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            if (!ConfigureManager.shutDown()) {
                run();
            }
        }


    }
}
