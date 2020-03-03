import java.util.Map;

public class IncrementForty extends Thread {
    public void run(){
        try{
            while (!(GlobalConfiguration.getState())) {
                String key = GlobalConfiguration.receiveQueueFour();
                GlobalConfiguration.computation(key,40);
                GlobalConfiguration.sendQueueFive(key);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!GlobalConfiguration.getState()) {
                run();
            }
        }

    }
}