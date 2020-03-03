/**
 * Created by ravi on 24/2/20.
 */
public class ModulousThread_4 extends Thread {
    public void run()
    {
        try {
            while (true){
                String item = Configuration.takeTask(Configuration.TaskPassServiceQueue_3);
            //System.out.println("Entered the Thread 4 with "+item);
            Configuration.Modulous(item, 5000);
            Configuration.requestCollector(item, Configuration.TaskPassServiceQueue_4);
            //System.out.println("Exit the Thread 4");
        }
        } catch (Exception e) {
            e.printStackTrace();}


    }
}
