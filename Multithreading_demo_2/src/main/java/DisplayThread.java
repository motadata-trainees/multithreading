/**
 * Created by ravi on 24/2/20.
 */
public class DisplayThread extends Thread {
    public void run()
    {

        try {
            while(true) {
                String item = Configuration.takeTask(Configuration.TaskPassServiceQueue_5);
                //System.out.println("Entered the Display with "+item);
                Configuration.Display(item);
                //System.out.println("Exit Display");
            }
        } catch (Exception e) {
            e.printStackTrace();}


    }
}
