package MultiThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by ravi on 27/2/20.
 */
public class GlobalConfiguration {
    private static BlockingQueue<String> productStore= new LinkedBlockingQueue<String>();
    static AtomicBoolean isShutdown = new AtomicBoolean(false);
    public static boolean isShutdownGet()
    {
        boolean getisShutdown=isShutdown.get();
        return getisShutdown;
    }
    public static String consume()
    {
        String task = null;

        try {
            task = productStore.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task;

    }
    public static void produce(String task)
    {
        try {
            productStore.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}