package MultiThreading;

/**
 * Created by parth on 23/2/20.
 */
public class BootManager {
    public static void main(String[] args){
        GlobalConfigure.fetch();
        SchedularThread schedular = new SchedularThread();
        CollecterService pingTask = new CollecterService();
        schedular.start();
        pingTask.start();
    }
}
