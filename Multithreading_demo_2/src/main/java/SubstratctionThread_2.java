/**
 * Created by ravi on 24/2/20.
 */
public class SubstratctionThread_2 extends Thread {
    public void run(){
        try {
            while(true) {

                String item = Configuration.takeTask(Configuration.TaskPassServiceQueue_1);
                //System.out.println("Entered the Thread 2 with "+item);
                Configuration.Substraction(item, 3);
                Configuration.requestCollector(item, Configuration.TaskPassServiceQueue_2);
                //System.out.println("Exit the Thread 2");
            }
        } catch (Exception e) {
            e.printStackTrace();}


    }
}
