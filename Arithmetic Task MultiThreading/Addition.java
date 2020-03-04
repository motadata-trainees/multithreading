import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Addition extends Thread {
   // private Lock lock=new ReentrantLock();
    public void run()
    {

        try {
            while (!ConfigurationManager.getIsRunning()) {
               //ConfigurationManager.setConfigData();

              String task = ConfigurationManager.takeAdditionTask();
              //String task="parth";
                if(task != null)
              {
                  int value=ConfigurationManager.getData(task);
                  value = value + 3;
                  ConfigurationManager.putData(task,value);
                  ConfigurationManager.setValSubtraction(task);
                  //System.out.println(ConfigurationManager.getConfigData());
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
