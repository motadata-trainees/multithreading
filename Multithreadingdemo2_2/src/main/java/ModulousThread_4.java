/**
 * Created by ravi on 24/2/20.
 */
public class ModulousThread_4 extends Thread {
    public void run()
    {
        try {
            while (!Configuration.isShutdownGet()){
                String item = Configuration.takeTask3();
                int number =Configuration.getConfigurationValue(item);
                number=number%5000;
                Configuration.setConfigurationValue(item,number);
                Configuration.requestCollector4(item);
                //System.out.println("Exit the Thread 4");
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
