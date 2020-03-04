import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nilesh on 25/2/20.
 */
public class Multiplication extends Thread {
    //private Lock lock=new ReentrantLock();
    public void run()
    {

        // ConfigurationManager.getConfigData();
        try {
            while (!ConfigurationManager.getIsRunning()) {
                //ConfigurationManager.setConfigData();
                String task=ConfigurationManager.takeMultiplicationTask();
                if(task != null)
                {
                    int value=ConfigurationManager.getData(task);
                    value=value*2;
                    ConfigurationManager.putData(task,value);
                    ConfigurationManager.setValDivide(task);
                    //System.out.println(ConfigurationManager.getConfigData());
                   // Thread.sleep(1000);

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
   /*     int value = 0;
                                                                        for (Map.Entry<String, Integer> entry : ConfigurationManager.getConfigData().entrySet()) {

                                                                            value = ConfigurationManager.getData(ConfigurationManager.getValSubtraction());
                                                                            value = value * 2;
                                                                            // ConfigurationManager.valAdd.put(value);
                                                                            entry.setValue(value);
                                                                            System.out.println(value);
                                                                          ConfigurationManager.setValMultiplication(entry.getKey());

                                                                        }
                                                                        lock.unlock();
                                                                        Thread.sleep(3000);*/