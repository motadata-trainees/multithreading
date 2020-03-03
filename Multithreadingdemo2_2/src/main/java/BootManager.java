import java.io.IOException;


public class BootManager {
    public static void main(String [] args) throws IOException
    {
        try {
            Configuration.loadConfig();
            JobSchedular jobschedular = new JobSchedular();
            AdditionThead_1 additionThread_1 = new AdditionThead_1();
            SubstractionThread_2 substratctionThread_2 = new SubstractionThread_2();
            MultiplicationThread_3 multiplicationThread_3 = new MultiplicationThread_3();
            ModulousThread_4 modulousThread_4 = new ModulousThread_4();
            DivisionThread_5 divisionThread_5 = new DivisionThread_5();
            DisplayThread displayThread = new DisplayThread();
            Configuration.initialzeReshedular();
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
