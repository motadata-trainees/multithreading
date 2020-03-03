package ProducerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by parth on 2/3/20.
 */
public class Consumer implements Runnable {
    @Override
    public void run() {
        try {
            while (!Config.shutDown()) {
                int num = Config.getSharedQueue();
                System.out.println("Consumed: " + num + ":by thread:" + Thread.currentThread().getName());
            }
            } catch (Exception err) {
                err.printStackTrace();
            }
            finally {
                if(!Config.shutDown())
                {
                    run();
                }
            }
        }
    }

