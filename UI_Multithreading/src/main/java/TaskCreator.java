import java.util.concurrent.Future;

/**
 * Created by ravi on 27/2/20.
 */
public class TaskCreator extends Thread{
    public static int count = 15;
    public void run()
    {
        try{
        while(count>0) {
            String task =GlobalConfiguration.getTask();
            GlobalConfiguration.submitTask(task);
            count =count -1;
        }
    } catch (Exception exception) {
        exception.printStackTrace();
    } finally {
        if (count>0)
            run();
    }
    }
}
