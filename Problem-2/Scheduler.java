import java.util.Map;
public class Scheduler extends Thread {
    public void run() {
        try {
            while (!(GlobalConfiguration.getState())) {
                GlobalConfiguration.randomTaskGenerator();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!(GlobalConfiguration.getState())) {
                run();
            }
        }
    }
}
