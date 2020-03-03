import java.util.Map;

public class IncrementTwenty extends Thread {
    public void run(){
        try{
            while(!(GlobalConfiguration.getState()))
            {
                String key=GlobalConfiguration.receiveQueueTwo();
                GlobalConfiguration.computation(key,20);
                GlobalConfiguration.sendQueueThree(key);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!(GlobalConfiguration.getState())) {
                run();
            }
        }
    }
}