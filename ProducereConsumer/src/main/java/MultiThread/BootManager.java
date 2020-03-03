package MultiThread;

/**
 * Created by ravi on 27/2/20.
 */
public class BootManager {
    public static void main(String args[])
    {
        Producer producer = new Producer();
        Consumer consumer1= new Consumer();
        Consumer consumer2= new Consumer();
        Consumer consumer3= new Consumer();
        Consumer consumer4= new Consumer();
        producer.start();
        consumer1.setName("consumer1");
        consumer1.start();
        consumer2.setName("consumer2");
        consumer2.start();
        consumer3.setName("consumer3");
        consumer3.start();
        consumer4.setName("consumer4");
        consumer4.start();

    }
}
