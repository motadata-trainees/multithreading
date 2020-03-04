/**
 * Created by nilesh on 25/2/20.
 */
public class Result extends Thread {
    public void run()
    {
        // ConfigurationManager.getConfigData();
        try {
            while (!ConfigurationManager.getIsRunning()) {
                //ConfigurationManager.setConfigData();
                String task=ConfigurationManager.takeResultTask();
                if(task != null)
                {
                   // ConfigurationManager.getConfigData();

                    System.out.println(ConfigurationManager.getConfigData());
                   // ConfigurationManager.ConfigData.remove(task);



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
