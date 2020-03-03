package exmaple;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by parth on 24/2/20.
 */
public class Subtraction extends Thread {

    Lock lock=new ReentrantLock();

    public void run()
    {
        try {

           while (!ConfigureManager.shutDown()) {

               String task = ConfigureManager.takeSubtractionTask();

               if(task != null)
               {
                   float value = ConfigureManager.getData(task);

                   value = value -40;

                   ConfigureManager.putData(task,value);

                   ConfigureManager.setValMul(task);
               }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(!ConfigureManager.shutDown())
            {
                run();
            }
        }

    }
}
