package SingleThread;

/**
 * Created by ravi on 27/2/20.
 */
public class BootManager {
    public static void main(String args[])
    {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();

    }
}
