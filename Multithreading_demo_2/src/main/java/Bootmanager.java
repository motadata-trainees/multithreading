import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Bootmanager {
    public static void main(String [] args) throws IOException
    {
        try {
            Configuration.fetch();
            JobSchedular jobschedular = new JobSchedular();
            AdditionThread_1 additionThread_1 = new AdditionThread_1();
            SubstratctionThread_2 substratctionThread_2 = new SubstratctionThread_2();
            MultiplicationThread_3 multiplicationThread_3 = new MultiplicationThread_3();
            ModulousThread_4 modulousThread_4 = new ModulousThread_4();
            DivisionThread_5 divisionThread_5 = new DivisionThread_5();
            DisplayThread displayThread = new DisplayThread();
            jobschedular.start();
            additionThread_1.start();
            substratctionThread_2.start();
            multiplicationThread_3.start();
            modulousThread_4.start();
            displayThread.start();
            divisionThread_5.start();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
