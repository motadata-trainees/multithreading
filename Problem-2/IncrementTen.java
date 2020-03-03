import java.util.Map;
public class IncrementTen extends Thread {
    public void run(){
        try{
            while(!(GlobalConfiguration.getState()))
            {
                String key=GlobalConfiguration.receiveQueueOne();
                GlobalConfiguration.computation(key,10);
                GlobalConfiguration.sendQueueTwo(key);
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