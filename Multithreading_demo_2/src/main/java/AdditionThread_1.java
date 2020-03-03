import java.io.IOException;

public class AdditionThread_1 extends Thread {
    public void run()
    {
        try {
            while (true){

            String item = Configuration.takeTask(Configuration.collectorQueue);
                //System.out.println("Entered the Thread 1 with "+item);
            Configuration.Addition(item, 10);
            Configuration.requestCollector(item, Configuration.TaskPassServiceQueue_1);
           //System.out.println("Exit the Thread 1");
        }
        } catch (Exception e) {
            e.printStackTrace();}

        }
}
