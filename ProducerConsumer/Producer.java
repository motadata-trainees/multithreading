package ProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by parth on 2/3/20.
 */
public class Producer implements Runnable {

    @Override
    public void run() {
        try {
            while (!Config.shutDown()) {
                int number = Config.getRandom();
                System.out.println("Produced:" + number + ":by thread:" + Thread.currentThread().getName());
                Config.setSharedQueue(number);
            }
        }catch (Exception err) {
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

