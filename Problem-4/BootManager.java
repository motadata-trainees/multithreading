public class BootManager {

    public static void main(String[] args) {
        try {
            Producer produce = new Producer("Producer Thread ");
            Consumer consumerThread1 = new Consumer("Consumer Thread-1");
            Consumer consumerThread2 = new Consumer("Consumer Thread-2");
            Consumer consumerThread3 = new Consumer("Consumer Thread-3");
            Consumer consumerThread4 = new Consumer("Consumer Thread-4");
            produce.start();
            consumerThread1.start();
            consumerThread2.start();
            consumerThread3.start();
            consumerThread4.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

