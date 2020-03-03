/**
 * Created by ravi on 24/2/20.
 */
public class MultiplicationThread_3 extends Thread{
    public void run()
    {
        try {
            while(!Configuration.isShutdownGet()) {

                String item = Configuration.takeTask2();
                int number =Configuration.getConfigurationValue(item);
                number=number*5;
                Configuration.setConfigurationValue(item,number);
                Configuration.requestCollector3(item);
                //System.out.println("Exit Thread 3");
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
