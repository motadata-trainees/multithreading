/**
 * Created by ravi on 24/2/20.
 */
public class DivisionThread_5 extends Thread {
    public void run()
    {
        try {
            while (!Configuration.isShutdownGet()) {
                String item = Configuration.takeTask4();
                if (item != null) {
                    int number =Configuration.getConfigurationValue(item);
                    number=number/2;
                    Configuration.setConfigurationValue(item,number);
                    Configuration.requestCollector5(item);
                    //System.out.println("Exit the Thread 5");
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
