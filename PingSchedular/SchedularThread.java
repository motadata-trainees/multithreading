package MultiThreading;

import java.util.HashMap;

/**
 * Created by parth on 23/2/20.
 */
public class SchedularThread extends Thread {

    public void run() {

        try {
            System.out.println("Entered the schedular Thread");

            long currentTime = System.currentTimeMillis();

            while (!GlobalConfigure.getRunnable()) {
                Thread.sleep(10000);

                HashMap<String,Integer> test = GlobalConfigure.getData();

                for (HashMap.Entry<String, Integer> entry : test.entrySet()) {

                        if (entry.getValue() > 0) {
                            entry.setValue(entry.getValue() - 10);
                            if (entry.getValue() == 0) {
                                currentTime = System.currentTimeMillis() - currentTime;
                                System.out.println("time is:"+currentTime/1000);
                                currentTime = System.currentTimeMillis();
                                GlobalConfigure.setSharedQueueData(entry.getKey());
                                entry.setValue(GlobalConfigure.getPartialdata(entry.getKey()));
                            }
                        }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(!GlobalConfigure.getRunnable()) {
                run();
            }
        }
    }
}
