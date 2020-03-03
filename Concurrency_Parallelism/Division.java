import java.util.HashMap;

public class Division implements Runnable {
    public void run() {
        try{
            while (!ConfigurationManager.GetState()) {
                    int div = 2;
                    div = ConfigurationManager.DivQueueTake() / 2;
                    ConfigurationManager.DivQueue(div);


        }
    }catch(Exception e){
            e.printStackTrace();

        }
        finally {
            if(!ConfigurationManager.GetState()){
                run();
            }
        }
    }
}