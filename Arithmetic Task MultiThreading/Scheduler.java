import java.util.Map;

/**
 * Created by nilesh on 27/2/20.
 */
public class Scheduler extends Thread {
    public void run() {
        try {
            while (!ConfigurationManager.getIsRunning()) {

                String key=ConfigurationManager.getScheduler().poll();
                //remove commented part for execute the result
                if(key!=null) {
                    ConfigurationManager.setValAddition(key);
                    ConfigurationManager.getConfigData().remove(key);     //this removes data from HashMap so that data is not increased value
                }

                else {
                    ConfigurationManager.getConfiguration();        //this again get Config File and reset it
                    ConfigurationManager.setValueOfScheduler();
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
