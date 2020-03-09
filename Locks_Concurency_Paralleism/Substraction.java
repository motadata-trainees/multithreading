
public class Substraction  implements Runnable {
    public void run() {
        try {
            while (!ConfigurationManager.GetState()) {
                int sub = 10;
                String name = ConfigurationManager.SubQueueTake();
                sub = ConfigurationManager.hashget(name) - sub;

//                if(!ConfigurationManager.SubQueueContains(name)){
                ConfigurationManager.hashput(name,sub);
                ConfigurationManager.SubQueue(name);

            }
//            }
        }
        catch(Exception e){
            e.printStackTrace();
            ConfigurationManager.SetState(true);
        }
        finally {
            if(ConfigurationManager.GetState()==false){
                run();
            }
        }
    }
}
