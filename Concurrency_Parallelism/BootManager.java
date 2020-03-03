import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class BootManager  {
    public static void main(String[] args)throws Exception {
        try {
            ConfigurationManager.fetch();

            Addition addition = new Addition();
            Substraction substraction = new Substraction();
            Multiplication multiplication = new Multiplication();
            Division division = new Division();
            Printing printing = new Printing();

            Thread additionThread = new Thread(addition);
            Thread substractionThread = new Thread(substraction);
            Thread multiplicationThread = new Thread(multiplication);
            Thread divisionThread = new Thread(division);
            Thread printingThread = new Thread(printing);

            additionThread.start();
            substractionThread.start();
            multiplicationThread.start();
            divisionThread.start();

            printingThread.start();


        }catch(Exception e){e.printStackTrace();}
    }
}
