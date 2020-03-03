/**
 * Created by ravi on 24/2/20.
 */
public class DisplayThread extends Thread {
    public void run()
    {

        try {
            while(!Configuration.isShutdownGet()) {
                String item = Configuration.takeTask5();
                if (item != null) {
                    //System.out.println("Entered the Display with "+item);
                    Configuration.display(item);
                    Configuration.requestCollector6(item);

                    //System.out.println("Exit Display");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();}
        finally
        {
            if(!Configuration.isShutdownGet()){
                run();
            }
        }


    }
}
