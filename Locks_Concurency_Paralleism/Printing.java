import java.util.HashMap;

public class Printing implements Runnable {
    public void run() {
        try {
            while (!ConfigurationManager.GetState()) {
                String name=ConfigurationManager.PrintQueueTake();
                System.out.println(name+" "+ConfigurationManager.hashget(name));
                ConfigurationManager.PrintingQueue(name);
        }
        }catch(Exception e){
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
