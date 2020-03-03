import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class GlobalConfigManger {

    private static LinkedBlockingQueue<String> blockingQueue=new LinkedBlockingQueue<>();
    private static AtomicBoolean isNotready=new AtomicBoolean(false);


    public static void queueAdd() {
        try {
            blockingQueue.add("sam");
        } catch (Exception e) {
            {
                e.printStackTrace();
            }
        }
    }


    public static void queuetake() {
        try {
            blockingQueue.take();
        }catch(Exception e){e.printStackTrace();}
    }
    public static boolean getState(){
        return isNotready.get();
    }
    public static void  setState(boolean state){
        isNotready.set(state);
    }
}
