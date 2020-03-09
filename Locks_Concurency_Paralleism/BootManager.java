import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class BootManager {
    public static void main(String[] args)throws Exception {
        try {
            ConfigurationManager.fetch();

            Scheduler schedule=new Scheduler();
            Addition addition = new Addition();
            Substraction substraction = new Substraction();
            Multiplication multiplication = new Multiplication();
            Printing printing = new Printing();

            Thread scheduler=new Thread(schedule);
            Thread additionThread = new Thread(addition);
            Thread substractionThread = new Thread(substraction);
            Thread multiplicationThread = new Thread(multiplication);
            Thread printingThread = new Thread(printing);


            scheduler.start();
            additionThread.start();
            substractionThread.start();
            multiplicationThread.start();
            printingThread.start();


        }catch(Exception e){e.printStackTrace();}
    }
}
