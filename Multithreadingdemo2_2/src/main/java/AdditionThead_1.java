import java.io.IOException;

public class AdditionThead_1 extends Thread {
    public void run()
    {
        try {
            while (!Configuration.isShutdownGet()) {

                String item = Configuration.takeTask();
                if (item != null) {
                    //System.out.println("Entered the Thread 1 with "+item);
                    int number =Configuration.getConfigurationValue(item);
                    number=number+10;
                    Configuration.setConfigurationValue(item,number);
                    Configuration.requestCollector1(item);
                    //System.out.println("Exit the Thread 1");
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
