public class BootManager {
    public static void main(String[] args) {
        try {
            Scheduler schedule = new Scheduler();
            Thread t1 = new Thread(schedule);
            t1.start();
            System.out.println(Thread.currentThread().getName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
