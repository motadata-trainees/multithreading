/**
 * Created by ravi on 24/2/20.
 */
public class MultiplicationThread_3 extends Thread{
    public void run()
    {
        try {
            while(true) {
                String item = Configuration.takeTask(Configuration.TaskPassServiceQueue_2);
               //System.out.println("Entered the Thread 3 with "+item);
                Configuration.Multiplication(item, 10);
                Configuration.requestCollector(item, Configuration.TaskPassServiceQueue_3);
                //System.out.println("Exit Thread 3");
            }
        } catch (Exception e) {
            e.printStackTrace();}


    }
}
