import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GlobalConfiguration {
    public static BlockingQueue<Integer> queue=new LinkedBlockingQueue<Integer>(10);
    public static Integer value=0;
    public static AtomicBoolean isShutdown = new AtomicBoolean(false);
    public static Lock lock=new ReentrantLock();
    public static boolean getState()
    {
        return isShutdown.get();
    }
    public static void produce()
    {
        try {
            System.out.println(Thread.currentThread().getName()+" produced: " + value);
            queue.put(value);
            value = value + 1;
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void consume()
    {
        try {
            Integer valu = queue.take();
            System.out.println(Thread.currentThread().getName()+" consumed: " + valu);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
