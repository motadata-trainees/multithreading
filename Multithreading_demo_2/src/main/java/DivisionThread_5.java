/**
 * Created by ravi on 24/2/20.
 */
public class DivisionThread_5 extends Thread {
    public void run()
    {
        try {
            while (true){
                String item = Configuration.takeTask(Configuration.TaskPassServiceQueue_4);
                //System.out.println("Entered the Thread 5 with "+item);
                Configuration.Division(item, 4);
                Configuration.requestCollector(item, Configuration.TaskPassServiceQueue_5);
                //System.out.println("Exit the Thread 5");
            }
        } catch (Exception e) {
            e.printStackTrace();}


    }
}
