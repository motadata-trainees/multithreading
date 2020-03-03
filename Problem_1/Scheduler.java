import java.util.HashMap;
import java.util.Map;
public class Scheduler extends Thread {
    public void run() {
        try {
            while (!(GlobalConfig.getState())) {
                HashMap<String, Integer> localconfiglog = GlobalConfig.getConfiguration();
                for (Map.Entry<String, Integer> entry : localconfiglog.entrySet()) {
                    entry.setValue(entry.getValue() - 10);
                    if (entry.getValue() == 0) {
                        GlobalConfig.send(GlobalConfig.getkey(entry));
                        entry.setValue(GlobalConfig.getvalu(GlobalConfig.getkey(entry)));
                    }
                }
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!(GlobalConfig.getState())) {
                run();
            }
        }
    }
}
