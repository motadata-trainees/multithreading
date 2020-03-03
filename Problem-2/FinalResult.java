import java.util.Map;

public class FinalResult extends Thread {
    public void run(){
        try{
            while (!(GlobalConfiguration.getState())) {
                String key = GlobalConfiguration.receiveQueueFive();
                System.out.println("After computing(initial value+10+20+30+40), Final Value - Name:" + key + "  " + GlobalConfiguration.getFinalValue(key));
                GlobalConfiguration.sendQueueSix(key);
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