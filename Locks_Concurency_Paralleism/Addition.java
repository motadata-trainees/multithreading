import java.util.HashMap;

public class Addition  implements Runnable {


    public void run() {
        try {
            while (!ConfigurationManager.GetState()) {
                int add=10;
                String name=ConfigurationManager.AddQueueTake();
                add=add+ConfigurationManager.hashget(name);

//                if(!ConfigurationManager.AddQueueContains(name)){
                    ConfigurationManager.hashput(name,add);
                    ConfigurationManager.AddQueue(name);
                }

//            }
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