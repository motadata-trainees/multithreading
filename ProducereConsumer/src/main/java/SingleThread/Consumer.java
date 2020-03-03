package SingleThread;

/**
 * Created by ravi on 27/2/20.
 */
public class Consumer extends Thread {
    public void run() {
        try {
            while (!GlobalConfiguration.isShutdownGet()) {
                String product = GlobalConfiguration.consume();
                System.out.println("Consumer consumed " + product);
                //Thread.sleep(10);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (!GlobalConfiguration.isShutdownGet())
                run();
        }
    }
}
