package exmaple;

/**
 * Created by parth on 24/2/20.
 */
public class BootManager {
    public static void main(String[] args) throws InterruptedException {

        ConfigureManager.fetch();

        Addition addThread=new Addition();

        Subtraction subThread=new Subtraction();

        Multiplication multiThread=new Multiplication();

        Divide divThread=new Divide();

        Result resultThread=new Result();

        ConfigureManager.intialize();

        addThread.start();

        subThread.start();

        multiThread.start();

        divThread.start();

        resultThread.start();

    }
}
