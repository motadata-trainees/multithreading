import java.util.Map;
public class TaskCreator extends Thread {

    public void run() {
        try {
            while (!(GlobalConfiguration.gettState())) {
                GlobalConfiguration.randomTaskGenerator();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!(GlobalConfiguration.gettState())) {
                run();
            }
        }
    }
}
