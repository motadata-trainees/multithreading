import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nilesh on 25/2/20.
 */
public class Subtraction extends Thread {
   //. private Lock lock=new ReentrantLock();
    public void run()
    {

        // ConfigurationManager.getConfigData();
        try {
            while (!ConfigurationManager.getIsRunning()) {
                //ConfigurationManager.setConfigData();
                String task=ConfigurationManager.takeSubtractionTask();
                if(task != null)
                {
                    int value=ConfigurationManager.getData(task);
                    value=value-1;
                    ConfigurationManager.putData(task,value);
                    ConfigurationManager.setValMultiplication(task);
                   // System.out.println(ConfigurationManager.getConfigData());
                    //Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            //Config.isShutDown.set(false);
        }
        finally {
            // setIsRunning(true,false);
            if(!ConfigurationManager.getIsRunning())
            {
                run();
            }

        }
    }
}
