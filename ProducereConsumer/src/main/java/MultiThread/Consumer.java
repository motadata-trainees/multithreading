package MultiThread;

/**
 * Created by ravi on 27/2/20.
 */
public class Consumer extends Thread {
    public void run() {
        try {
            while (!GlobalConfiguration.isShutdownGet()) {
                String product = GlobalConfiguration.consume();
                System.out.println(Thread.currentThread().getName()+" consumed " + product);
                Thread.sleep(1);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (!GlobalConfiguration.isShutdownGet())
                run();
        }
    }
}
