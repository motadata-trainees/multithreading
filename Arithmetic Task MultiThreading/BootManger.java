import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;


public class BootManger {
    public static void main(String[] args) {

        ConfigurationManager configurationManager=new ConfigurationManager();
        try
        {
            configurationManager.getConfiguration();
            ConfigurationManager.setValueOfScheduler();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        Scheduler scheduler=new Scheduler();
        Addition add=new Addition();
        Subtraction sub=new Subtraction();
        Multiplication mul=new Multiplication();
        Divide div=new Divide();
        Result res=new Result();
        scheduler.start();
        add.start();
        sub.start();
        mul.start();
        div.start();
        res.start();
       // ReentrantLock

    }
}

//ProcessAppliedOnData Addition=new ProcessAppliedOnData("Multi");   data0.start();data1.start();data2.start();data3.start();
// ProcessAppliedOnData data1=new ProcessAppliedOnData("Add");
// ProcessAppliedOnData data2=new ProcessAppliedOnData("Sub");
// ProcessAppliedOnData data3=new ProcessAppliedOnData("Divide");