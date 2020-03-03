import java.util.Map;

public class IncrementThirty extends Thread {
    public void run(){
        try {
            while (!(GlobalConfiguration.getState())) {
                String key = GlobalConfiguration.receiveQueueThree();
                GlobalConfiguration.computation(key,30);
                GlobalConfiguration.sendQueueFour(key);
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