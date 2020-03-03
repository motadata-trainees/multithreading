/**
 * Created by ravi on 24/2/20.
 */
public class SubstractionThread_2 extends Thread {
    public void run(){
        try {
            while(!Configuration.isShutdownGet()) {

                String item = Configuration.takeTask1();
                if (item != null) {
                    int number =Configuration.getConfigurationValue(item);
                    number=number-5;
                    Configuration.setConfigurationValue(item,number);
                    Configuration.requestCollector2(item);
                    //System.out.println("Exit the Thread 2");
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
