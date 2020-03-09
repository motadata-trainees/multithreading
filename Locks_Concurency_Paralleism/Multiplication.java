import java.util.HashMap;

public class Multiplication implements Runnable {
    public void run() {

        try {
            while (!ConfigurationManager.GetState()) {

                int mul = 1;
                String name=ConfigurationManager.MulQueueTake();
                mul = ConfigurationManager.hashget(name) * mul;

//                if(!ConfigurationManager.MulQueueContains(name)){
                ConfigurationManager.hashput(name,mul);
                ConfigurationManager.MulQueue(name);
            }
//            }
        } catch (Exception e) {
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
