package exmaple;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by parth on 24/2/20.
 */
public class Divide extends Thread{
    Lock lock=new ReentrantLock();

    public void run()
    {
        try {

            while (!ConfigureManager.shutDown()) {

                String task = ConfigureManager.takeDivideTask();

                if(task != null)
                {
                    float value = ConfigureManager.getData(task);

                    value = value / 2;

                    ConfigureManager.putData(task,value);

                    ConfigureManager.setValResult(task);

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
