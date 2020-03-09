import java.util.HashMap;

public class Scheduler implements Runnable{
    public void run(){
        try {
            ConfigurationManager.PrintQueueAddFirst();
            while (!ConfigurationManager.GetState()) {

                for (HashMap.Entry<String, Integer> collector : ConfigurationManager.ConfigMap.entrySet()) {

                    if(ConfigurationManager.PrintQueueCheck(ConfigurationManager.HashMapIterator(collector))) {
                        ConfigurationManager.SchedulerQueueAdd(ConfigurationManager.HashMapIterator(collector));
                        ConfigurationManager.RemoveFromPrint(ConfigurationManager.HashMapIterator(collector));
                    }
                }
          Thread.sleep(10);
           }
        } catch (Exception e){
            ConfigurationManager.SetState(true);
            e.printStackTrace();
        }
        finally {
            if(ConfigurationManager.GetState()==false){
                run();
            }
        }
    }
}
