public class BootManager {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = new Scheduler();
            Consumer1 consumer1 = new Consumer1();

            Thread t1 = new Thread(scheduler);
            Thread t2 = new Thread(new Consumer1());
            Thread t3 = new Thread(new Consumer1());
            Thread t4 = new Thread(new Consumer1());

            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
